package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Vol_habilidadRepository{
    //Create
    public Vol_habilidad crear(Vol_habilidad volHabilidad);
    //Read
    public List<Vol_habilidad> getAll();
    public List<Vol_habilidad> show(Integer id);
    //Update
    public String update(Vol_habilidad volHabilidad, Integer id);
    //Delete
    public void delete(Integer id);
}
