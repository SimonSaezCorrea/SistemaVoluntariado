package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import Grupo4TBD.VoluntariosTBD.Repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class InstitucionRepoImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Institucion crear(Institucion institucion){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Institucion (nombre, descripcion)" +
                    "VALUES (:nombre, :descripcion)";
            conn.createQuery(sql, true)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("descripcion", institucion.getDescripcion())
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
            return conn.createQuery("select * from Institucion order by id ASC")
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institucion> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Institucion where id = :id_voluntario ")
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
            String updateSql = "update Voluntario set nombre=:nombre and descripcion=:descripcion WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("descripcion", institucion.getDescripcion())
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
