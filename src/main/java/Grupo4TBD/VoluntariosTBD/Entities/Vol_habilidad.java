package Grupo4TBD.VoluntariosTBD.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "vol_habilidad")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vol_habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_voluntario", referencedColumnName = "id")
    Voluntario voluntario;
    @ManyToOne
    @JoinColumn(name = "id_habilidad", referencedColumnName = "id")
    Habilidad habilidad;
}
