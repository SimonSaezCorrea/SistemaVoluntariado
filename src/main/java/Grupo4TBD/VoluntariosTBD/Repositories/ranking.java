package Grupo4TBD.VoluntariosTBD.Repositories;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

@Repository
public class ranking {
    @Id
    Integer id;
    @ForeignKey
    Integer id_voluntario;
    @ForeignKey
    Integer id_tarea;
    Integer puntaje;
    Integer flg_invitado;
    Integer flg_participa;
}
