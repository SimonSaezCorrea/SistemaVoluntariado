package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Ranking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository {
    //Create
    public Ranking crear(Ranking ranking);
    //Read
    public List<Ranking> getAll();
    public List<Ranking> show(Integer id);
    //Update
    public String update(Ranking ranking, Integer id);
    //Delete
    public void delete(Integer id);
}
