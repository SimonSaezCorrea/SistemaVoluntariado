package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "emergencia")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    @ManyToOne
    @JoinColumn(name = "id_institucion", referencedColumnName = "id")
    private Institucion institucion;
}
