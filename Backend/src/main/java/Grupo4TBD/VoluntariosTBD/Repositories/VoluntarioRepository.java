package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VoluntarioRepository{
    //Create
    public Voluntario crear(Voluntario voluntario);
    //Read
    public List<Voluntario> getAll();
    public List<Voluntario> show(Integer id);
    //Update
    public String update(Voluntario voluntario, Integer id);
    //Delete
    public void delete(Integer id);
    //Busca por id_usuario
    public Voluntario findByUsuario(Integer id_usuario);


}
