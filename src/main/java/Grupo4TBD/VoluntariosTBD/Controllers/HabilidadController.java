package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.HabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabilidadController {
    private final HabilidadRepository HabilidadRepository;

    HabilidadController(HabilidadRepository HabilidadRepository){
        this.HabilidadRepository = HabilidadRepository;
    }

    // crear C
    @PostMapping("/habilidad")
    public Habilidad crear(@RequestBody Habilidad habilidad) {
        return HabilidadRepository.crear(habilidad);
    }
    // get R
    @GetMapping("/habilidad")
    public List<Habilidad> getAllHabilidad() {
        return HabilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/habilidad/{id}")
    public List<Habilidad> show(@PathVariable Integer id){
        return HabilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/habilidad/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Habilidad habilidad, @PathVariable Integer id){
        return HabilidadRepository.update(habilidad,id);
    }

    // borrar D
    @DeleteMapping("/habilidad/{id}")
    public void borrar(@PathVariable Integer id){
        HabilidadRepository.delete(id);
    }
}
