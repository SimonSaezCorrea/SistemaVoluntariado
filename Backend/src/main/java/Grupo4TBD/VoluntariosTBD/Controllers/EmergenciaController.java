package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Emergencia;
import Grupo4TBD.VoluntariosTBD.Repositories.EmergenciaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergencia")
public class EmergenciaController {
    private final EmergenciaRepository EmergenciaRepository;

    EmergenciaController(EmergenciaRepository EmergenciaRepository){
        this.EmergenciaRepository = EmergenciaRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Emergencia crear(@RequestBody Emergencia emergencia) {
        return EmergenciaRepository.crear(emergencia);
    }
    // get R
    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Emergencia> getAllEmergencia() {
        return EmergenciaRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Emergencia> show(@PathVariable Integer id){
        return EmergenciaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    @ResponseBody
    public String updateEmergencia(@RequestBody Emergencia emergencia, @PathVariable Integer id){
        return EmergenciaRepository.update(emergencia,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        EmergenciaRepository.delete(id);
    }
}
