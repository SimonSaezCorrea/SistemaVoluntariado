package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    //Create
    public Usuario crear(Usuario usuario);
    //Read
    public List<Usuario> getAll();
    public List<Usuario> show(Integer id);
    //Update
    public String update(Usuario usuario, Integer id);
    //Delete
    public void delete(Integer id);
    //Read by email
    public Usuario findByEmail(String email);
    //Read session
    public Usuario getUserInSession();
}
