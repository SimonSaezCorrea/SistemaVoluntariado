package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Tarea_habilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Tarea_habilidadRepoImp implements Tarea_habilidadRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea_habilidad crear(Tarea_habilidad tarea_habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Tarea_habilidad (id, id_emehab, id_tarea)" +
                    "VALUES (:id, :id_emehab, :id_tarea)";
            conn.createQuery(sql, true)
                    .addParameter("id", tarea_habilidad.getId())
                    .addParameter("id_emehab", tarea_habilidad.getId_emehab())
                    .addParameter("id_tarea", tarea_habilidad.getId_tarea())
                    .executeUpdate();
            return tarea_habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea_habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Tarea_habilidad order by id")
                    .executeAndFetch(Tarea_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea_habilidad> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Tarea_habilidad where id=:id ")
                    .addParameter("id", id)
                    .executeAndFetch(Tarea_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Tarea_habilidad tarea_habilidad, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE Tarea_habilidad SET id_emehab=:id_emehab," +
                    "id_tarea=:id_tarea " +
                    "WHERE id=:id;";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_emehab", tarea_habilidad.getId_emehab())
                    .addParameter("id_tarea", tarea_habilidad.getId_tarea())
                    .executeUpdate();
            return "Se actualizó la Tarea_habilidad";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Tarea_habilidad";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Tarea_habilidad where id=:id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
