package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Vol_habilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class Vol_habilidadRepoImp implements Vol_habilidadRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Vol_habilidad crear(Vol_habilidad vol_habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Vol_habilidad (id_voluntario, id_habilidad)" +
                    "VALUES (:id_voluntario, :id_habilidad)";
            conn.createQuery(sql, true)
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
                    .executeUpdate();
            return vol_habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Vol_habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Vol_habilidad order by id ASC")
                    .executeAndFetch(Vol_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Vol_habilidad> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Vol_habilidad where id=:id ")
                    .addParameter("id", id)
                    .executeAndFetch(Vol_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Vol_habilidad vol_habilidad, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Vol_habilidad set id_voluntario=:id_voluntario and id_habilidad=:id_habilidad WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
                    .executeUpdate();
            return "Se actualizó la Vol_habilidad";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Vol_habilidad";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Vol_habilidad where id=:id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
