package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepoImp implements TareaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea crear(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Tarea (nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, id_emergencia, fecha_inicio, fecha_fin, id_estado_tarea)" +
                    "VALUES (:nombre, :descrip, :cant_vol_requeridos, :cant_vol_inscritos, :id_emergencia, :fecha_inicio, :fecha_fin, :id_estado_tarea)";
            conn.createQuery(sql, true)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("cant_vol_requeridos", tarea.getCant_vol_requeridos())
                    .addParameter("cant_vol_inscritos", tarea.getCant_vol_inscritos())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("fecha_inicio", tarea.getFecha_inicio())
                    .addParameter("fecha_fin", tarea.getFecha_fin())
                    .addParameter("id_estado_tarea", tarea.getId_estado_tarea())
                    .executeUpdate();
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Tarea order by id ASC")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> show(Integer id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Tarea where id=:id ")
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Tarea tarea, Integer id) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update Tarea set nombre=:nombre and " +
                    "descrip=:descrip and " +
                    "cant_vol_requeridos=:cant_vol_requeridos and " +
                    "cant_vol_inscritos=:cant_vol_inscritos and " +
                    "id_emergencia=:id_emergencia and " +
                    "fecha_inicio=:fecha_inicio and " +
                    "fecha_fin=:fecha_fin and " +
                    "id_estado_tarea=:id_estado_tarea " +
                    "WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("cant_vol_requeridos", tarea.getCant_vol_requeridos())
                    .addParameter("cant_vol_inscritos", tarea.getCant_vol_inscritos())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("fecha_inicio", tarea.getFecha_inicio())
                    .addParameter("fecha_fin", tarea.getFecha_fin())
                    .addParameter("id_estado_tarea", tarea.getId_estado_tarea())
                    .executeUpdate();
            return "Se actualizó la Tarea";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Tarea";
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from Tarea where id=:id ")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
