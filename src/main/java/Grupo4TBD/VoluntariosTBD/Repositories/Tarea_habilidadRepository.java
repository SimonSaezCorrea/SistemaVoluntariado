package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tarea_habilidadRepository extends JpaRepository<Habilidad,String> {
}
