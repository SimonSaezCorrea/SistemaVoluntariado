package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Ranking {
    private Integer id;
    private Integer id_voluntario;
    private Integer id_tarea;
    private Integer puntaje;
    private Integer flg_invitado;
    private Integer flg_participa;
}
