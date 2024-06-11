package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("docentes", DocenteCollection.listarDocentes());
        return "Docente/listar";
    }

    @GetMapping("/alta")
    public String alta(Model model) {
        model.addAttribute("docente", new Docente());
        return "Docente/alta";
    }

    @PostMapping("/alta")
    public String alta(@ModelAttribute Docente docente) {
        DocenteCollection.agregarDocente(docente);
        return "redirect:/docentes/listar";
    }

    @GetMapping("/baja")
    public String mostrarFormularioEliminar() {
        return "Docente/eliminar";
    }

    @PostMapping("/baja")
    public String baja(@RequestParam String codigo) {
        DocenteCollection.eliminarDocente(codigo);
        return "redirect:/docentes/listar";
    }

    @GetMapping("/buscar")
    public String buscarCarrera() {
        return "Docente/buscar-docente";
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar(@RequestParam String codigo, Model model) {
        Docente docente = DocenteCollection.buscarDocente(codigo);
        if (docente == null) {
            return "redirect:/docentes/buscar";
        }
        model.addAttribute("docente", docente);
        return "Docente/modificar";
}
}