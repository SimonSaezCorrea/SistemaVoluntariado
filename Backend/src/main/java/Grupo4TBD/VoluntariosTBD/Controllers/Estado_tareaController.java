package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Estado_tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.Estado_tareaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado_tarea")
public class Estado_tareaController {
    private final Estado_tareaRepository Estado_tareaRepository;

    Estado_tareaController(Estado_tareaRepository Estado_tareaRepository){
        this.Estado_tareaRepository = Estado_tareaRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Estado_tarea crear(@RequestBody Estado_tarea estado_tarea) {
        return Estado_tareaRepository.crear(estado_tarea);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Estado_tarea> getAllEstado_tarea() {
        return Estado_tareaRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Estado_tarea> show(@PathVariable Integer id){
        return Estado_tareaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public String updateEstado_tarea(@RequestBody Estado_tarea estado_tarea, @PathVariable Integer id){
        return Estado_tareaRepository.update(estado_tarea,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        Estado_tareaRepository.delete(id);
    }
}
