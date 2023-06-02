package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HabilidadRepository {
    //Create
    public Habilidad crear(Habilidad habilidad);
    //Read
    public List<Habilidad> getAll();
    public List<Habilidad> show(Integer id);
    //Update
    public String update(Habilidad habilidad, Integer id);
    //Delete
    public void delete(Integer id);
}
