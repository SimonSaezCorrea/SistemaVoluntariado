package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepoImp implements VoluntarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Voluntario crear(Voluntario voluntario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Voluntario (id, nombre, id_usuario) " +
                    "VALUES (:id, :nombre, :id_usuario)";
            Integer nextId = obtenerSiguienteId();
            voluntario.setId(nextId);
            conn.createQuery(sql, true)
                    .addParameter("id", nextId)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("id_usuario", voluntario.getId_usuario())
                    .executeUpdate();
            return voluntario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Voluntario order by id")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Voluntario where id = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Voluntario voluntario, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Voluntario set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("id_usuario", voluntario.getId_usuario())
                    .executeUpdate();
            return "Se actualizó Voluntario";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Voluntario";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Voluntario where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Voluntario findByUsuario(Integer id_usuario) {
        try (Connection conn = sql2o.open()) {
            List<Voluntario> voluntarios = conn.createQuery("select * from Voluntario where id_usuario = :id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetch(Voluntario.class);
            return voluntarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer obtenerSiguienteId() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT MAX(id) + 1 FROM Voluntario")
                    .executeScalar(Integer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
