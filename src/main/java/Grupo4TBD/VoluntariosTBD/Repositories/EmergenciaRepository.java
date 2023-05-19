package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Emergencia;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmergenciaRepository {
    //Create
    public Emergencia crear(Emergencia emergencia);
    //Read
    public List<Emergencia> getAll();
    public List<Emergencia> show(Integer id);
    //Update
    public String update(Emergencia emergencia, Integer id);
    //Delete
    public void delete(Integer id);
}
