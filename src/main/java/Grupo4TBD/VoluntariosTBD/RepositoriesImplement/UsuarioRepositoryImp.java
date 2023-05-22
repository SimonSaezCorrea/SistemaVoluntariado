package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UsuarioRepositoryImp implements  UsuarioRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Usuario crear(Usuario usuario){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Usuario (id, nombre, email, password)" +
                    "VALUES (:id, :nombre, :email, :password)";
            conn.createQuery(sql, true)
                    .addParameter("id", usuario.getId())
                    .addParameter("nombre", usuario.getNombre())
                    .addParameter("email", usuario.getEmail())
                    .addParameter("password", usuario.getPassword())
                    .executeUpdate();
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Usuario order by id ")
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> show(Integer id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Usuario where id=:id")
                    .addParameter("id", id)
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Usuario usuario, Integer id) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update Usuario set id=:id, " +
                    "nombre=:nombre, " +
                    "email=:email" +
                    "password=:password " +
                    "where id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", usuario.getNombre())
                    .addParameter("email", usuario.getEmail())
                    .addParameter("clave", usuario.getPassword())
                    .executeUpdate();
            return "Se actualizó el Usuario";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Usuario";
        }
    }

    @Override
        public void delete(Integer id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from Usuario where id=:id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Usuario findByEmail(String email) {
        try (Connection conn = sql2o.open()) {
            List<Usuario> usuarios = conn.createQuery("select * from Usuario where email=:email")
                    .addParameter("email", email)
                    .executeAndFetch(Usuario.class);
            return usuarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
