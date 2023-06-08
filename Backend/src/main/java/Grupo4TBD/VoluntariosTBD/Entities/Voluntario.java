package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Voluntario {
    private Integer id;
    private String nombre;
    private Integer id_usuario;
    //Cuidar formato WGS84, el cual establece
    //que las coordenadas son angulares.
    private Float latitud;
    private Float longitud;
}
