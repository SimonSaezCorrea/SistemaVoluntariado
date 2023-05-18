package Grupo4TBD.VoluntariosTBD.RestControllers;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Eme_habilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Eme_habilidadController {
    private final Eme_habilidadRepository Eme_habilidadRepository;

    Eme_habilidadController(Eme_habilidadRepository Eme_habilidadRepository){
        this.Eme_habilidadRepository = Eme_habilidadRepository;
    }

    // crear C
    @PostMapping("/eme_habilidad")
    public Eme_habilidad crear(@RequestBody Eme_habilidad eme_habilidad) {
        return Eme_habilidadRepository.crear(eme_habilidad);
    }
    // get R
    @GetMapping("/eme_habilidad")
    public List<Eme_habilidad> getAllEme_habilidad() {
        return Eme_habilidadRepository.getAll();
    }
    // get by id R
    @GetMapping("/eme_habilidad/{id}")
    public List<Eme_habilidad> show(@PathVariable Integer id){
        return Eme_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/eme_habilidad/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Eme_habilidad eme_habilidad, @PathVariable Integer id){
        return Eme_habilidadRepository.update(eme_habilidad,id);
    }

    // borrar D
    @DeleteMapping("/eme_habilidad/{id}")
    public void borrar(@PathVariable Integer id){
        Eme_habilidadRepository.delete(id);
    }

}
