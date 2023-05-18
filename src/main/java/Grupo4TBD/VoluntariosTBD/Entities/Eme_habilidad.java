package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Eme_habilidad {
    private Integer id;
    private Emergencia emergencia;
    private Habilidad habilidad;
}
