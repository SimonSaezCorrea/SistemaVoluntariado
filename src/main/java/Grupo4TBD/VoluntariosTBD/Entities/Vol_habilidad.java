package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Vol_habilidad {
    Integer id;
    Voluntario voluntario;
    Habilidad habilidad;
}
