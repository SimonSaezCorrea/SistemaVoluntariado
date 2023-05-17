package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "tarea")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nombre;
    String descrip;
    Integer cant_vol_requeridos;
    Integer cant_vol_inscritos;
    @ManyToOne
    @JoinColumn(name = "id_emergencia", referencedColumnName = "id")
    Emergencia emergencia;
    Date fecha_inicio;
    Date fecha_fin;
    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    Estado_tarea estado_tarea;
}
