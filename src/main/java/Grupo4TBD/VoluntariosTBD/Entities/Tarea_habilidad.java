package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Tarea_habilidad {
    Integer id;
    Eme_habilidad emehab;
    Tarea tarea;
}
