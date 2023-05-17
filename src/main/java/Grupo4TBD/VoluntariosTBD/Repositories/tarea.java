package Grupo4TBD.VoluntariosTBD.Repositories;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class tarea {
    @Id
    Integer id;
    String nombre;
    String descrip;
    Integer cant_vol_requeridos;
    Integer cant_vol_inscritos;
    @ForeignKey
    Integer id_emergencia;
    Date fecha_inicio;
    Date fecha_fin;
    @ForeignKey
    Integer id_estado;
}
