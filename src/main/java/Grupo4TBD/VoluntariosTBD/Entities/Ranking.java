package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ranking")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_voluntario", referencedColumnName = "id")
    Voluntario voluntario;
    @ManyToOne
    @JoinColumn(name = "id_tarea", referencedColumnName = "id")
    Tarea tarea;
    Integer puntaje;
    Integer flg_invitado;
    Integer flg_participa;
}
