package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;

import java.util.List;


public interface Vol_habilidadRepository {
    //Create
    Vol_habilidad crear(Vol_habilidad volHabilidad);

    //Read
    List<Vol_habilidad> getAll();

    List<Vol_habilidad> show(Integer id);

    //Update
    String update(Vol_habilidad volHabilidad, Integer id);

    //Delete
    void delete(Integer id);
}
