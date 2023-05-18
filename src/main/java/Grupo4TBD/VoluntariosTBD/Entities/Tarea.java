package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tarea {
    Integer id;
    String nombre;
    String descrip;
    Integer cant_vol_requeridos;
    Integer cant_vol_inscritos;
    Emergencia emergencia;
    Date fecha_inicio;
    Date fecha_fin;
    Estado_tarea estado_tarea;
}
