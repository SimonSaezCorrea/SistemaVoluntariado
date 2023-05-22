package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
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
    public List<Usuario> getAllTarea() {
        return UsuarioRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    public List<Usuario> show(@PathVariable Integer id){
        return UsuarioRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Usuario usuario, @PathVariable Integer id){
        return UsuarioRepository.update(usuario,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id){
        UsuarioRepository.delete(id);
    }
}
