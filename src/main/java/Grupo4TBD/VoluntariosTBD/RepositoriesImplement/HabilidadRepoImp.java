package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class HabilidadRepoImp implements HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Habilidad crear(Habilidad habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Habilidad (descripcion)" +
                    "VALUES (:descripcion)";
            conn.createQuery(sql, true)
                    .addParameter("descripcion", habilidad.getDescripcion())
                    .executeUpdate();
            return habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Habilidad order by id ASC")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Habilidad> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Habilidad where id = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Habilidad habilidad, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Habilidad set descripcion=:descripcion WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("descripcion", habilidad.getDescripcion())
                    .executeUpdate();
            return "Se actualizó la Habilidad";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Habilidad";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Habilidad where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
