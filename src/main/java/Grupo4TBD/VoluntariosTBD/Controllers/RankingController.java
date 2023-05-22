package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Ranking;
import Grupo4TBD.VoluntariosTBD.Repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankingController {

    private final RankingRepository RankingRepository;

    RankingController(RankingRepository RankingRepository){
        this.RankingRepository = RankingRepository;
    }

    // crear C
    @PostMapping("/ranking")
    public Ranking crear(@RequestBody Ranking ranking) {
        return RankingRepository.crear(ranking);
    }
    // get R
    @GetMapping("/ranking")
    public List<Ranking> getAllRanking() {
        return RankingRepository.getAll();
    }
    // get by id R
    @GetMapping("/ranking/{id}")
    public List<Ranking> show(@PathVariable Integer id){
        return RankingRepository.show(id);
    }

    // actualizar U
    @PutMapping("/ranking/{id}")
    @ResponseBody
    public String updateBoleta(@RequestBody Ranking ranking, @PathVariable Integer id){
        return RankingRepository.update(ranking,id);
    }

    // borrar D
    @DeleteMapping("/ranking/{id}")
    public void borrar(@PathVariable Integer id){
        RankingRepository.delete(id);
    }
}
