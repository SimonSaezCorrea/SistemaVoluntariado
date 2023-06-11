package Grupo4TBD.VoluntariosTBD.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Ranking;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepoImp implements RankingRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    /*Discuss datatype in DB.*/
    public Ranking crear(Ranking ranking){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Ranking (id, id_voluntario, id_tarea, puntaje, flg_invitado, flg_participa)" +
                    "VALUES (:id, :id_voluntario, :id_tarea, :puntaje, :flg_invitado, :flg_participa)";
            conn.createQuery(sql, true)
                    .addParameter("id",ranking.getId())
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .addParameter("flg_invitado", ranking.getFlg_invitado())
                    .addParameter("flg_participa", ranking.getFlg_participa())
                    .executeUpdate();
            return ranking;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ranking order by id")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> show(Integer id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ranking where id=:id ")
                    .addParameter("id", id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Ranking ranking, Integer id){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE Ranking SET id_voluntario=:id_voluntario, " +
                    "id_tarea=:id_tarea, puntaje=:puntaje, " +
                    "flg_invitado=:flg_invitado," +
                    "flg_participa=:flg_participa " +
                    "WHERE id=:id;";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .addParameter("flg_invitado", ranking.getFlg_invitado())
                    .addParameter("flg_participa", ranking.getFlg_participa())
                    .executeUpdate();
            return "Se actualizó la Ranking";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Ranking";
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Ranking where id=:id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Voluntario> seleccionarVoluntarioPorTarea(Integer id_tarea){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select voluntario.id, voluntario.nombre, voluntario.id_usuario from voluntario " +
                            "join ranking on " +
                            "ranking.id_voluntario = voluntario.id " +
                            "where ranking.id_tarea=:id_tarea " +
                            "order by ranking.puntaje desc;")
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
