package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tarea_habilidad {
    Integer id;
    Eme_habilidad emehab;
    Tarea tarea;
}
