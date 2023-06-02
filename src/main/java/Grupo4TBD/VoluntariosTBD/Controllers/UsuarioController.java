package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository UsuarioRepository;

    UsuarioController(UsuarioRepository usuarioRepository){
        this.UsuarioRepository = usuarioRepository;
    }

    // crear C
    @PostMapping()
    public Usuario crear(@RequestBody Usuario usuario) {
        return UsuarioRepository.crear(usuario);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Usuario> getAllUsuario() {
        return UsuarioRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Usuario> show(@PathVariable Integer id){
        return UsuarioRepository.show(id);
    }
    @GetMapping("/perfil")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public Usuario getUser() {
        return UsuarioRepository.getUserInSession();
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer id){
        return UsuarioRepository.update(usuario,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        UsuarioRepository.delete(id);
    }
}
