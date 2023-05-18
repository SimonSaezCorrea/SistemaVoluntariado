package Grupo4TBD.VoluntariosTBD.RestControllers;


import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Vol_habilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Vol_habilidadController {

    private final Vol_habilidadRepository Vol_habilidadRepository;

    Vol_habilidadController(Vol_habilidadRepository Vol_habilidadRepository){
        this.Vol_habilidadRepository = Vol_habilidadRepository;
    }

    // crear C
    @PostMapping("/vol_habilidad")
    public Vol_habilidad crear(@RequestBody Vol_habilidad vol_habilidad) {
        return Vol_habilidadRepository.crear(vol_habilidad);
    }
    // get R
    @GetMapping("/vol_habilidad")
    public List<Vol_habilidad> getAllVol_habilidad() {
        return Vol_habilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/vol_habilidad/{id}")
    public List<Vol_habilidad> show(@PathVariable Integer id){
        return Vol_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/vol_habilidad/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Vol_habilidad vol_habilidad, @PathVariable Integer id){
        return Vol_habilidadRepository.update(vol_habilidad,id);
    }

    // borrar D
    @DeleteMapping("/vol_habilidad/{id}")
    public void borrar(@PathVariable Integer id){
        Vol_habilidadRepository.delete(id);
    }
}
