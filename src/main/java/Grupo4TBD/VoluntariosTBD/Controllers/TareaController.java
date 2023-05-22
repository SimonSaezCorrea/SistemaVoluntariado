package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TareaController {
    private final Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository TareaRepository;

    TareaController(TareaRepository TareaRepository){
        this.TareaRepository = TareaRepository;
    }

    // crear C
    @PostMapping("/tarea")
    public Tarea crear(@RequestBody Tarea tarea) {
        return TareaRepository.crear(tarea);
    }
    // get R
    @GetMapping("/tarea")
    public List<Tarea> getAllTarea() {
        return TareaRepository.getAll();
    }
    // get by id R
    @GetMapping("/tarea/{id}")
    public List<Tarea> show(@PathVariable Integer id){
        return TareaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/tarea/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Tarea tarea, @PathVariable Integer id){
        return TareaRepository.update(tarea,id);
    }

    // borrar D
    @DeleteMapping("/tarea/{id}")
    public void borrar(@PathVariable Integer id){
        TareaRepository.delete(id);
    }
}
