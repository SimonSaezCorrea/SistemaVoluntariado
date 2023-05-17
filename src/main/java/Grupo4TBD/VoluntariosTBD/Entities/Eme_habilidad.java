package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "eme_habilidad")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Eme_habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_emergencia",referencedColumnName = "id")
    private Emergencia emergencia;
    @ManyToOne
    @JoinColumn(name = "id_habilidad",referencedColumnName = "id")
    private Habilidad habilidad;
}
