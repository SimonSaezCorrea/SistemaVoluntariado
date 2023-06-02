package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InstitucionRepository {
    //Create
    public Institucion crear(Institucion institucion);
    //Read
    public List<Institucion> getAll();
    public List<Institucion> show(Integer id);
    //Update
    public String update(Institucion institucion, Integer id);
    //Delete
    public void delete(Integer id);
}
