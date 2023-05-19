package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepoImp implements HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Habilidad crear(Habilidad habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Habilidad (descrip)" +
                    "VALUES (:descrip)";
            conn.createQuery(sql, true)
                    .addParameter("descrip", habilidad.getDescrip())
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
            return conn.createQuery("select * from Habilidad order by id")
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
            String updateSql = "update Habilidad set descrip=:descripcion WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("descrip", habilidad.getDescrip())
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
