package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarea_habilidad")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarea_habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_emehab", referencedColumnName = "id")
    Eme_habilidad emehab;
    @ManyToOne
    @JoinColumn(name = "id_tarea", referencedColumnName = "id")
    Tarea tarea;
}
