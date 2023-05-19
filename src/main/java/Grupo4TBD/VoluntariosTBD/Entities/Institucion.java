package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Institucion {
    private Integer id;
    private String nombre;
    private String descrip;
}
