package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ranking {
    Integer id;
    Voluntario voluntario;
    Tarea tarea;
    Integer puntaje;
    Integer flg_invitado;
    Integer flg_participa;
}
