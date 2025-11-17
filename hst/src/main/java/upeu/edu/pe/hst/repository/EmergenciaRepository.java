package upeu.edu.pe.hst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.hst.entity.Emergencia;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Long> {
}
