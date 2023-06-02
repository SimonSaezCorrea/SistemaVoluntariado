package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.HabilidadRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {
    private final HabilidadRepository HabilidadRepository;

    HabilidadController(HabilidadRepository HabilidadRepository){
        this.HabilidadRepository = HabilidadRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public Habilidad crear(@RequestBody Habilidad habilidad) {
        return HabilidadRepository.crear(habilidad);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Habilidad> getAllHabilidad() {
        return HabilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Habilidad> show(@PathVariable Integer id){
        return HabilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateHabilidad(@RequestBody Habilidad habilidad, @PathVariable Integer id){
        return HabilidadRepository.update(habilidad,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        HabilidadRepository.delete(id);
    }
}
