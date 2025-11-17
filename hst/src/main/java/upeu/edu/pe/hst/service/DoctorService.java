package upeu.edu.pe.hst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.hst.entity.Doctor;
import upeu.edu.pe.hst.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> listarTodos() {
        return doctorRepository.findAll();
    }

    public Doctor guardar(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor obtenerPorId(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }
}
