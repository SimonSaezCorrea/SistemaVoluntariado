package Grupo4TBD.VoluntariosTBD.Controllers;


import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Vol_habilidadRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vol_habilidad")
public class Vol_habilidadController {

    private final Vol_habilidadRepository Vol_habilidadRepository;

    Vol_habilidadController(Vol_habilidadRepository Vol_habilidadRepository){
        this.Vol_habilidadRepository = Vol_habilidadRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public Vol_habilidad crear(@RequestBody Vol_habilidad vol_habilidad) {
        return Vol_habilidadRepository.crear(vol_habilidad);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Vol_habilidad> getAllVol_habilidad() {
        return Vol_habilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR') || hasRole('ROLE_VOLUNTARIO')")
    public List<Vol_habilidad> show(@PathVariable Integer id){
        return Vol_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateVol_habilidad(@RequestBody Vol_habilidad vol_habilidad, @PathVariable Integer id){
        return Vol_habilidadRepository.update(vol_habilidad,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        Vol_habilidadRepository.delete(id);
    }
}
