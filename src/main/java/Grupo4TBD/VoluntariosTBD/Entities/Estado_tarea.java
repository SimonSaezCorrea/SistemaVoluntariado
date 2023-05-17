package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "estado_tarea")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estado_tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
}
