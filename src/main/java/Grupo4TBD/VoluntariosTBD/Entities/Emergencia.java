package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Emergencia {
    private Integer id;
    private String nombre;
    private String descrip;
    private Date finicio;
    private Date ffin;
    private Integer id_institucion;
}
