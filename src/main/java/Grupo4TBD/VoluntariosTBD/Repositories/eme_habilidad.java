package Grupo4TBD.VoluntariosTBD.Repositories;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

@Repository
public class eme_habilidad {
    @Id
    Integer id;
    @ForeignKey
    Integer id_emergencia;
    @ForeignKey
    Integer id_habilidad;
}
