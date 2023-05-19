package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface Eme_habilidadRepository {
    //Create
    public Eme_habilidad crear(Eme_habilidad eme_habilidad);
    //Read
    public List<Eme_habilidad> getAll();
    public List<Eme_habilidad> show(Integer id);
    //Update
    public String update(Eme_habilidad eme_habilidad, Integer id);
    //Delete
    public void delete(Integer id);
}
