package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Models.Register;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    VoluntarioRepository voluntarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // crear C
    @PostMapping()
    public String crear(@RequestBody Register registro) {
        Usuario usuario = new Usuario();
        usuario.setEmail(registro.getEmail());
        usuario.setRol("VOLUNTARIO"); // Rol por defecto
        usuario.setPassword(passwordEncoder.encode(registro.getPassword()));
        // Usuario ya registrado
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null)
            return "Email ya se encuentra registrado";
        usuario = usuarioRepository.crear(usuario);
        if (usuario == null)
            return "ERROR: No se pudo registrar Usuario";
        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(registro.getNombre());
        voluntario.setId_usuario(usuario.getId());
        voluntario = voluntarioRepository.crear(voluntario);
        if (voluntario == null) {
            usuarioRepository.delete(usuario.getId());
            return "ERROR: No se pudo registrar Usuario";
        }
        return "Usuario registrado exitosamente";
    }
}
