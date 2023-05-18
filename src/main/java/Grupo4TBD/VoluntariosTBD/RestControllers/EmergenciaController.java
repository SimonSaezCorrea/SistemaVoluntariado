package Grupo4TBD.VoluntariosTBD.RestControllers;

import Grupo4TBD.VoluntariosTBD.Entities.Emergencia;
import Grupo4TBD.VoluntariosTBD.Repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmergenciaController {
    private final EmergenciaRepository EmergenciaRepository;

    EmergenciaController(EmergenciaRepository EmergenciaRepository){
        this.EmergenciaRepository = EmergenciaRepository;
    }

    // crear C
    @PostMapping("/emergencia")
    public Emergencia crear(@RequestBody Emergencia emergencia) {
        return EmergenciaRepository.crear(emergencia);
    }
    // get R
    @GetMapping("/emergencia")
    public List<Emergencia> getAllEmergencia() {
        return EmergenciaRepository.getAll();
    }
    // get by id R
    @GetMapping("/emergencia/{id}")
    public List<Emergencia> show(@PathVariable Integer id){
        return EmergenciaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/emergencia/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Emergencia emergencia, @PathVariable Integer id){
        return EmergenciaRepository.update(emergencia,id);
    }

    // borrar D
    @DeleteMapping("/emergencia/{id}")
    public void borrar(@PathVariable Integer id){
        EmergenciaRepository.delete(id);
    }
}
