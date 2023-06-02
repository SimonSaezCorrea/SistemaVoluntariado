package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Vol_habilidad {
    private Integer id;
    private Integer id_voluntario;
    private Integer id_habilidad;
}
