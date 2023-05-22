package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioController {
    private final VoluntarioRepository VoluntarioRepository;

    VoluntarioController(VoluntarioRepository VoluntarioRepository){
        this.VoluntarioRepository = VoluntarioRepository;
    }

    // crear C
    @PostMapping("/voluntario")
    public Voluntario crear(@RequestBody Voluntario voluntario) {
        return VoluntarioRepository.crear(voluntario);
    }
    // get R
    @GetMapping("/voluntario")
    public List<Voluntario> getAllVoluntario() {
        return VoluntarioRepository.getAll();
    }
    // get by id R
    @GetMapping("/voluntario/{id}")
    public List<Voluntario> show(@PathVariable Integer id){
        return VoluntarioRepository.show(id);
    }

    // actualizar U
    @PutMapping("/voluntario/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Voluntario voluntario, @PathVariable Integer id){
        return VoluntarioRepository.update(voluntario,id);
    }

    // borrar D
    @DeleteMapping("/voluntario/{id}")
    public void borrar(@PathVariable Integer id){
        VoluntarioRepository.delete(id);
    }
}
