package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Eme_habilidadRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eme_habilidad")
public class Eme_habilidadController {
    private final Eme_habilidadRepository Eme_habilidadRepository;

    Eme_habilidadController(Eme_habilidadRepository Eme_habilidadRepository){
        this.Eme_habilidadRepository = Eme_habilidadRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public Eme_habilidad crear(@RequestBody Eme_habilidad eme_habilidad) {
        return Eme_habilidadRepository.crear(eme_habilidad);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Eme_habilidad> getAllEme_habilidad() {
        return Eme_habilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Eme_habilidad> show(@PathVariable Integer id){
        return Eme_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateEme_habilidad(@RequestBody Eme_habilidad eme_habilidad, @PathVariable Integer id){
        return Eme_habilidadRepository.update(eme_habilidad,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        Eme_habilidadRepository.delete(id);
    }

}
