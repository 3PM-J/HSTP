package upeu.edu.pe.hst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.hst.entity.Emergencia;
import upeu.edu.pe.hst.service.DoctorService;
import upeu.edu.pe.hst.service.EmergenciaService;

@Controller
@RequestMapping("/emergencias")
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public String listarEmergencias(Model model) {
        model.addAttribute("listaEmergencias", emergenciaService.listarTodos());
        return "emergencias/lista_emergencias";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("emergencia", new Emergencia());
        model.addAttribute("listaDoctores", doctorService.listarTodos());
        return "emergencias/nueva_emergencia";
    }

    @PostMapping("/guardar")
    public String guardarEmergencia(@ModelAttribute("emergencia") Emergencia emergencia) {
        emergenciaService.guardar(emergencia);
        return "redirect:/emergencias/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Emergencia emergencia = emergenciaService.obtenerPorId(id);
        model.addAttribute("emergencia", emergencia);
        model.addAttribute("listaDoctores", doctorService.listarTodos());
        return "emergencias/editar_emergencia";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmergencia(@PathVariable Long id) {
        emergenciaService.eliminar(id);
        return "redirect:/emergencias/";
    }
}
