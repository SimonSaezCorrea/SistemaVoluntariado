package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Eme_habilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Eme_habilidadRepoImp implements Eme_habilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Eme_habilidad crear(Eme_habilidad eme_habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Vol_habilidad (id_emergencia, id_habilidad)" +
                    "VALUES (:id_emergencia, :id_habilidad)";
            conn.createQuery(sql, true)
                    .addParameter("id_emergencia", eme_habilidad.getId_emergencia())
                    .addParameter("id_habilidad", eme_habilidad.getId_habilidad())
                    .executeUpdate();
            return eme_habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Eme_habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Eme_habilidad order by id ASC")
                    .executeAndFetch(Eme_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Eme_habilidad> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Eme_habilidad where id=:id ")
                    .addParameter("id", id)
                    .executeAndFetch(Eme_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Eme_habilidad eme_habilidad, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Vol_habilidad set id_emergencia=:id_emergencia and id_habilidad=:id_habilidad WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_emergencia", eme_habilidad.getId_emergencia())
                    .addParameter("id_habilidad", eme_habilidad.getId_habilidad())
                    .executeUpdate();
            return "Se actualizó la Eme_habilidad";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Eme_habilidad";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Eme_habilidad where id=:id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
