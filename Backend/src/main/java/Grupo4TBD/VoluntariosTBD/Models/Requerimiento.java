package Grupo4TBD.VoluntariosTBD.Models;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class Requerimiento extends Voluntario {
    private Integer cant_requerimientos;
}
