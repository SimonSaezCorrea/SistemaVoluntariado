package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Models.AuthCredentials;
import Grupo4TBD.VoluntariosTBD.Models.Register;
import Grupo4TBD.VoluntariosTBD.Models.Sesion;
import Grupo4TBD.VoluntariosTBD.Models.TokenInfo;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import Grupo4TBD.VoluntariosTBD.Services.TokenUtils;
import Grupo4TBD.VoluntariosTBD.Services.UserDetailsImp;
import Grupo4TBD.VoluntariosTBD.Services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    private final VoluntarioRepository voluntarioRepository;

    private final TokenUtils tokenUtils;

    private final UserDetailsServiceImpl usuarioDetailsServiceImpl;

    private final AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    // crear C
    @PostMapping("/register")
    public String registrar(@RequestBody Register registro) {
        Usuario usuario = new Usuario();
        usuario.setEmail(registro.getEmail());
        usuario.setRol("VOLUNTARIO"); // Rol por defecto
        usuario.setPassword(passwordEncoder().encode(registro.getPassword()));
        // Usuario ya registrado
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null)
            return "Email ya se encuentra registrado";
        usuario = usuarioRepository.crear(usuario);
        if (usuario == null)
            return "ERROR: No se pudo registrar Usuario";
        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(registro.getNombre());
        voluntario.setId_usuario(usuario.getId());
        voluntario.setLatitud(registro.getLatitud());
        voluntario.setLongitud(registro.getLongitud());
        voluntario = voluntarioRepository.crear(voluntario);
        if (voluntario == null) {
            usuarioRepository.delete(usuario.getId());
            return "ERROR: No se pudo registrar Usuario";
        }
        return "Usuario registrado exitosamente";
    }

    @GetMapping("/sesion")
    public Sesion sesion() {
        Sesion sesion = new Sesion();
        Usuario usuario = usuarioRepository.getUserInSession();
        if (usuario == null)
            return null;
        Voluntario voluntario = voluntarioRepository.findByUsuario(usuario.getId());
        if (voluntario == null)
            return null;
        sesion.setId(usuario.getId());
        sesion.setEmail(usuario.getEmail());
        sesion.setNombre(voluntario.getNombre());
        sesion.setLongitud(voluntario.getLongitud());
        sesion.setLatitud(voluntario.getLatitud());
        return sesion;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthCredentials authenticationReq) {
        try {
            logger.info("Autenticando al usuario {}", authenticationReq.getEmail());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationReq.getEmail(),
                            authenticationReq.getPassword()));

            final UserDetailsImp userDetails = usuarioDetailsServiceImpl.loadUserByUsername(
                    authenticationReq.getEmail());

            final String jwt = tokenUtils.createToken(userDetails);

            Sesion sesion = new Sesion();
            Usuario usuario = usuarioRepository.findByEmail(authenticationReq.getEmail());

            if (usuario == null) {
                // El usuario no existe
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Voluntario voluntario = voluntarioRepository.findByUsuario(usuario.getId());

            if (voluntario == null) {
                // No se encontró el voluntario asociado al usuario
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            sesion.setId(usuario.getId());
            sesion.setEmail(usuario.getEmail());
            sesion.setNombre(voluntario.getNombre());
            sesion.setLongitud(voluntario.getLongitud());
            sesion.setLatitud(voluntario.getLatitud());

            return ResponseEntity.ok(new TokenInfo(sesion, jwt));
        } catch (AuthenticationException e) {
            // El usuario no pudo ser autenticado
            logger.error("Error de autenticación: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            // Manejo de otras excepciones
            logger.error("Error al autenticar al usuario: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
