package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Voluntario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nombre;
}
