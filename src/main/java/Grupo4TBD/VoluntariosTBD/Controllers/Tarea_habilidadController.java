package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Tarea_habilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Tarea_habilidadController {
    private final Tarea_habilidadRepository Tarea_habilidadRepository;

    Tarea_habilidadController(Tarea_habilidadRepository Tarea_habilidadRepository){
        this.Tarea_habilidadRepository = Tarea_habilidadRepository;
    }

    // crear C
    @PostMapping("/tarea_habilidad")
    public Tarea_habilidad crear(@RequestBody Tarea_habilidad tarea_habilidad) {
        return Tarea_habilidadRepository.crear(tarea_habilidad);
    }
    // get R
    @GetMapping("/tarea_habilidad")
    public List<Tarea_habilidad> getAllTarea_habilidad() {
        return Tarea_habilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/tarea_habilidad/{id}")
    public List<Tarea_habilidad> show(@PathVariable Integer id){
        return Tarea_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/tarea_habilidad/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Tarea_habilidad tarea_habilidad, @PathVariable Integer id){
        return Tarea_habilidadRepository.update(tarea_habilidad,id);
    }

    // borrar D
    @DeleteMapping("/tarea_habilidad/{id}")
    public void borrar(@PathVariable Integer id){
        Tarea_habilidadRepository.delete(id);
    }
}
