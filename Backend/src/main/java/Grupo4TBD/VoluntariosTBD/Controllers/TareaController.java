package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    private final Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository TareaRepository;

    TareaController(TareaRepository TareaRepository){
        this.TareaRepository = TareaRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Tarea crear(@RequestBody Tarea tarea) {
        return TareaRepository.crear(tarea);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Tarea> getAllTarea() {
        return TareaRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Tarea> show(@PathVariable Integer id){
        return TareaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateTarea(@RequestBody Tarea tarea, @PathVariable Integer id){
        return TareaRepository.update(tarea,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        TareaRepository.delete(id);
    }

    @GetMapping("/mapa/{id_tarea}/{numberLimit}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Voluntario> cercanoTarea(@PathVariable Integer id_tarea, @PathVariable Integer numberLimit){
        Tarea tarea = TareaRepository.show(id_tarea).get(0);
        return TareaRepository.cercanosTarea(tarea, numberLimit);
    }
}
