package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Eme_habilidad {
    private Integer id;
    private Emergencia emergencia;
    private Habilidad habilidad;
}
