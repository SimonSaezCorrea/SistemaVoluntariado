package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Emergencia;
import Grupo4TBD.VoluntariosTBD.Repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepoImp implements EmergenciaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Emergencia crear(Emergencia emergencia){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Emergencia (nombre, descrip, finicio, ffin, id_institucion)" +
                    "VALUES (:nombre, :descrip, :finicio, :ffin, :id_institucion)";
            conn.createQuery(sql, true)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("finicio", emergencia.getFinicio())
                    .addParameter("ffin", emergencia.getFfin())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .executeUpdate();
            return emergencia;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emergencia> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Emergencia order by id")
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emergencia> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Emergencia where id=:id ")
                    .addParameter("id", id)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Emergencia emergencia, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Emergencia set nombre=:nombre and " +
                    "descrip=:descrip and " +
                    "finicio=:finicio and " +
                    "ffin=:ffin and " +
                    "id_institucion=:id_institucion " +
                    "WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("finicio", emergencia.getFinicio())
                    .addParameter("ffin", emergencia.getFfin())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .executeUpdate();
            return "Se actualizó la Emergencia";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Emergencia";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Emergencia where id=:id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
