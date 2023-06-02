package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Tarea_habilidadRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea_habilidad")
public class Tarea_habilidadController {
    private final Tarea_habilidadRepository Tarea_habilidadRepository;

    Tarea_habilidadController(Tarea_habilidadRepository Tarea_habilidadRepository){
        this.Tarea_habilidadRepository = Tarea_habilidadRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Tarea_habilidad crear(@RequestBody Tarea_habilidad tarea_habilidad) {
        return Tarea_habilidadRepository.crear(tarea_habilidad);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Tarea_habilidad> getAllTarea_habilidad() {
        return Tarea_habilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Tarea_habilidad> show(@PathVariable Integer id){
        return Tarea_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateTarea_habilidad(@RequestBody Tarea_habilidad tarea_habilidad, @PathVariable Integer id){
        return Tarea_habilidadRepository.update(tarea_habilidad,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        Tarea_habilidadRepository.delete(id);
    }
}
