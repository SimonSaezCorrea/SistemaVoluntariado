package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Estado_tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.Estado_tareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Estado_tareaRepoImp implements Estado_tareaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Estado_tarea crear(Estado_tarea estado_tarea){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Estado_tarea (id, descrip)" +
                    "VALUES (:id, :descrip)";
            conn.createQuery(sql, true)
                    .addParameter("id", estado_tarea.getId())
                    .addParameter("descrip", estado_tarea.getDescrip())
                    .executeUpdate();
            return estado_tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Estado_tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Estado_tarea order by id")
                    .executeAndFetch(Estado_tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Estado_tarea> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Estado_tarea where id=:id ")
                    .addParameter("id", id)
                    .executeAndFetch(Estado_tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Estado_tarea estado_tarea, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE Estado_tarea SET descrip=:descrip WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("descrip", estado_tarea.getDescrip())
                    .executeUpdate();
            return "Se actualizó la Estado_tarea";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Estado_tarea";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Estado_tarea where id=:id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
