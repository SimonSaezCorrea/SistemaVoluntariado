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
    public Tarea crear(Tarea tarea){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Tarea (id, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, " +
                    "id_emergencia, finicio, ffin, id_estado, geom)" +
                    "VALUES (:id, :nombre, :descrip, :cant_vol_requeridos, :cant_vol_inscritos, :id_emergencia, " +
                    ":finicio, :ffin, :id_estado, ST_GeomFromText('POINT(:latitud :longitud)', 4326)";
            conn.createQuery(sql, true)
                    .addParameter("id", tarea.getId())
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("cant_vol_requeridos", tarea.getCant_vol_requeridos())
                    .addParameter("cant_vol_inscritos", tarea.getCant_vol_inscritos())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("finicio", tarea.getFinicio())
                    .addParameter("ffin", tarea.getFfin())
                    .addParameter("id_estado", tarea.getId_estado())
                    .addParameter("longitud", tarea.getLongitud())
                    .addParameter("latitud",tarea.getLatitud())
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
            return conn.createQuery("select id, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, " +
                            "id_emergencia, finicio, ffin, id_estado, ST_X(geom) AS latitud, " +
                            "ST_Y(geom) AS longitud from Tarea order by id ")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> show(Integer id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, " +
                            "id_emergencia, finicio, ffin, id_estado, ST_X(geom) AS latitud, " +
                            "ST_Y(geom) AS longitud from Tarea where id=:id ")
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
            String updateSql = "UPDATE Tarea SET nombre=:nombre" +
                    "descrip=:descrip, cant_vol_requeridos=:cant_vol_requeridos, " +
                    "cant_vol_inscritos=:cant_vol_inscritos," +
                    "id_emergencia=:id_emergencia, " +
                    "finicio=:finicio, ffin=:ffin," +
                    "id_estado=:id_estado," +
                    "geom = ST_GeomFromText('POINT(:latitud :longitud)', 4326) " +
                    "WHERE id=:id;";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("cant_vol_requeridos", tarea.getCant_vol_requeridos())
                    .addParameter("cant_vol_inscritos", tarea.getCant_vol_inscritos())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("finicio", tarea.getFinicio())
                    .addParameter("ffin", tarea.getFfin())
                    .addParameter("id_estado", tarea.getId_estado())
                    .addParameter("longitud", tarea.getLongitud())
                    .addParameter("latitud",tarea.getLatitud())
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
