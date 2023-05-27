package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Ranking;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.RankingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {

    private final RankingRepository RankingRepository;

    RankingController(RankingRepository RankingRepository){
        this.RankingRepository = RankingRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Ranking crear(@RequestBody Ranking ranking) {
        return RankingRepository.crear(ranking);
    }
    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Ranking> getAllRanking() {
        return RankingRepository.getAll();
    }
    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Ranking> show(@PathVariable Integer id){
        return RankingRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateRanking(@RequestBody Ranking ranking, @PathVariable Integer id){
        return RankingRepository.update(ranking,id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable Integer id){
        RankingRepository.delete(id);
    }

    @GetMapping("/select/{id_tarea}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Voluntario> seleccionarVoluntarioPorTarea(@PathVariable Integer id_tarea){
        return RankingRepository.seleccionarVoluntarioPorTarea(id_tarea);
    }
}
