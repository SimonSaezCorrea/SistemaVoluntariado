package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Ranking {
    Integer id;
    Voluntario voluntario;
    Tarea tarea;
    Integer puntaje;
    Integer flg_invitado;
    Integer flg_participa;
}
