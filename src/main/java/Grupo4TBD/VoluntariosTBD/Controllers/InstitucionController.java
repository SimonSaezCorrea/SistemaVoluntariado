package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import Grupo4TBD.VoluntariosTBD.Repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitucionController {
    private final InstitucionRepository InstitucionRepository;

    InstitucionController(InstitucionRepository InstitucionRepository){
        this.InstitucionRepository = InstitucionRepository;
    }

    // crear C
    @PostMapping("/institucion")
    public Institucion crear(@RequestBody Institucion institucion) {
        return InstitucionRepository.crear(institucion);
    }
    // get R
    @GetMapping("/institucion")
    public List<Institucion> getAllInstitucion() {
        return InstitucionRepository.getAll();
    }
    // get by id R
    @GetMapping("/institucion/{id}")
    public List<Institucion> show(@PathVariable Integer id){
        return InstitucionRepository.show(id);
    }

    // actualizar U
    @PutMapping("/institucion/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Institucion institucion, @PathVariable Integer id){
        return InstitucionRepository.update(institucion,id);
    }

    // borrar D
    @DeleteMapping("/institucion/{id}")
    public void borrar(@PathVariable Integer id){
        InstitucionRepository.delete(id);
    }
}
