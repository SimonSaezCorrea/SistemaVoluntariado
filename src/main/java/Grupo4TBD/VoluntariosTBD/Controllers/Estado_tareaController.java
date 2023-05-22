package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Estado_tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.Estado_tareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Estado_tareaController {
    private final Estado_tareaRepository Estado_tareaRepository;

    Estado_tareaController(Estado_tareaRepository Estado_tareaRepository){
        this.Estado_tareaRepository = Estado_tareaRepository;
    }

    // crear C
    @PostMapping("/estado_tarea")
    public Estado_tarea crear(@RequestBody Estado_tarea estado_tarea) {
        return Estado_tareaRepository.crear(estado_tarea);
    }
    // get R
    @GetMapping("/estado_tarea")
    public List<Estado_tarea> getAllEstado_tarea() {
        return Estado_tareaRepository.getAll();
    }
    // get by id R
    @GetMapping("/estado_tarea/{id}")
    public List<Estado_tarea> show(@PathVariable Integer id){
        return Estado_tareaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/estado_tarea/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Estado_tarea estado_tarea, @PathVariable Integer id){
        return Estado_tareaRepository.update(estado_tarea,id);
    }

    // borrar D
    @DeleteMapping("/estado_tarea/{id}")
    public void borrar(@PathVariable Integer id){
        Estado_tareaRepository.delete(id);
    }
}
