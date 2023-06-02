package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea_habilidad;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface Tarea_habilidadRepository {
    //Create
    public Tarea_habilidad crear(Tarea_habilidad tareaHabilidad);
    //Read
    public List<Tarea_habilidad> getAll();
    public List<Tarea_habilidad> show(Integer id);
    //Update
    public String update(Tarea_habilidad tareaHabilidad, Integer id);
    //Delete
    public void delete(Integer id);
}
