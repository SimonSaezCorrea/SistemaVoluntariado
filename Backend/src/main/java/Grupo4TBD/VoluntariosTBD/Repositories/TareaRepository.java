package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TareaRepository {
    //Create
    public Tarea crear(Tarea tarea);
    //Read
    public List<Tarea> getAll();
    public List<Tarea> show(Integer id);
    //Update
    public String update(Tarea tarea, Integer id);
    //Delete
    public void delete(Integer id);

    public List<Voluntario> cercanosTarea(Tarea tarea, Integer numberLimit);
}
