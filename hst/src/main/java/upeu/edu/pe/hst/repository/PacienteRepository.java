package upeu.edu.pe.hst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.hst.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
