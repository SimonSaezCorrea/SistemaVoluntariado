package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class VoluntarioRepoImp implements VoluntarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Voluntario crear(Voluntario Voluntario){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Voluntario (nombre)" +
                    "VALUES (:nombre)";
            conn.createQuery(sql, true)
                    .addParameter("nombre", Voluntario.getNombre())
                    .executeUpdate();
            return Voluntario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Voluntario order by id ASC")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> show(Integer id_voluntario) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Voluntario where id = :id_voluntario ")
                    .addParameter("id",id_voluntario)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Integer id_voluntario) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Voluntario where id = :id_voluntario ")
                    .addParameter("id",id_voluntario)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public String update(Voluntario Voluntario, Integer id_voluntario){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Voluntario set nombre=:nombre WHERE id=:id_voluntario";
            conn.createQuery(updateSql)
                    .addParameter("id", id_voluntario)
                    .addParameter("nombre", Voluntario.getNombre())
                    .executeUpdate();
            return "Se actualizó la Voluntario";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Voluntario";
        }
    }
}
