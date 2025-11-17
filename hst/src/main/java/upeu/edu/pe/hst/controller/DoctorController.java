package upeu.edu.pe.hst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.hst.entity.Doctor;
import upeu.edu.pe.hst.service.DoctorService;

@Controller
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public String listarDoctores(Model model) {
        model.addAttribute("listaDoctores", doctorService.listarTodos());
        return "doctores/lista_doctores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctores/nuevo_doctor";
    }

    @PostMapping("/guardar")
    public String guardarDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.guardar(doctor);
        return "redirect:/doctores/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.obtenerPorId(id);
        model.addAttribute("doctor", doctor);
        return "doctores/editar_doctor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDoctor(@PathVariable Long id) {
        doctorService.eliminar(id);
        return "redirect:/doctores/";
    }
}
