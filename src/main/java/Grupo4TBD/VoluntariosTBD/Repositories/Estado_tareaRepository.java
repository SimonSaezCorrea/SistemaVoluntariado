package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Estado_tarea;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface Estado_tareaRepository {
    //Create
    public Estado_tarea crear(Estado_tarea estadoTarea);
    //Read
    public List<Estado_tarea> getAll();
    public List<Estado_tarea> show(Integer id);
    //Update
    public String update(Estado_tarea estadoTarea, Integer id);
    //Delete
    public void delete(Integer id);
}
