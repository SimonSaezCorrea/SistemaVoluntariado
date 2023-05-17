package Grupo4TBD.VoluntariosTBD.Repositories;

import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

@Repository
public class habilidad {
    @Id
    Integer id;
    String descripcion;
}
