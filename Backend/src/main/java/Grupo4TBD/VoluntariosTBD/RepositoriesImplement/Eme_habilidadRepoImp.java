package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Eme_habilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Eme_habilidadRepoImp implements Eme_habilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Eme_habilidad crear(Eme_habilidad eme_habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Eme_habilidad (id ,id_emergencia, id_habilidad)" +
                    "VALUES (:id, :id_emergencia, :id_habilidad)";
            conn.createQuery(sql, true)
                    .addParameter("id", eme_habilidad.getId())
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
            return conn.createQuery("select * from Eme_habilidad order by id")
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
    /*The function can update the DB entitie, but there is and issue about de return
    * "Error in executeUpdate, Se retornó un resultado cuando no se esperaba ninguno."
    * Nota: Pasa con todos*/
    public String update(Eme_habilidad eme_habilidad, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Eme_habilidad set id_emergencia=:id_emergencia WHERE id=:id;" +
                    "update Eme_habilidad set id_habilidad=:id_habilidad WHERE id=:id;";
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
