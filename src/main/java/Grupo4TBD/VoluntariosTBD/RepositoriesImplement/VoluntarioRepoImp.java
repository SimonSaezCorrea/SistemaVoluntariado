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
    public Voluntario crear(Voluntario voluntario){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Voluntario (nombre)" +
                    "VALUES (:nombre)";
            conn.createQuery(sql, true)
                    .addParameter("nombre", voluntario.getNombre())
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
}
