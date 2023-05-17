package Grupo4TBD.VoluntariosTBD.Repositories;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

@Repository
public class tarea_habilidad {
    @Id
    Integer id;
    @ForeignKey
    Integer id_emehab;
    @ForeignKey
    Integer id_tarea;
}
