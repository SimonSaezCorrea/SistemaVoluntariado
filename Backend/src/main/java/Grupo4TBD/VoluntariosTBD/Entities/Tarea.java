package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Tarea {
    private Integer id;
    private String nombre;
    private String descrip;
    private Integer cant_vol_requeridos;
    private Integer cant_vol_inscritos;
    private Integer id_emergencia;
    private Date finicio;
    private Date ffin;
    private Integer id_estado;
    //Cuidar formato WGS84, el cual establece
    //que las coordenadas son angulares.
    private Float latitud;
    private Float longitud;
}
