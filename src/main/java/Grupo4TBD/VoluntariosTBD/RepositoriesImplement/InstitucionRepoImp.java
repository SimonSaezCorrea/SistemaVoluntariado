package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import Grupo4TBD.VoluntariosTBD.Repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepoImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Institucion crear(Institucion institucion){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Institucion (id, nombre, descrip)" +
                    "VALUES (:id, :nombre, :descrip)";
            conn.createQuery(sql, true)
                    .addParameter("id", institucion.getId())
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("descrip", institucion.getDescrip())
                    .executeUpdate();
            return institucion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institucion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Institucion order by id")
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institucion> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Institucion where id = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Institucion institucion, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE Institucion SET nombre=:nombre WHERE id=:id;" +
                    "UPDATE Institucion SET descrip=:descrip WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("descrip", institucion.getDescrip())
                    .executeUpdate();
            return "Se actualizó la Institucion";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Institucion";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Institucion where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
