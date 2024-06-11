package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("carreras", CarreraCollection.listarCarreras());
        return "Carrera/listar";
    }

    @GetMapping("/alta")
    public String alta(Model model) {
        model.addAttribute("carrera", new Carrera());
        return "Carrera/alta";
    }

    @PostMapping("/alta")
    public String alta(@ModelAttribute Carrera carrera) {
        CarreraCollection.agregarCarrera(carrera);
        return "redirect:/carreras/listar";
    }

    @GetMapping("/baja")
    public String mostrarFormularioEliminar() {
        return "Carrera/eliminar";
    }

    @PostMapping("/baja")
    public String baja(@RequestParam String codigo) {
        CarreraCollection.eliminarCarrera(codigo);
        return "redirect:/carreras/listar";
    }

    @GetMapping("/buscar")
    public String buscarCarrera() {
        return "Carrera/buscar-carrera";
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar(@RequestParam String codigo, Model model) {
        Carrera carrera = CarreraCollection.buscarCarrera(codigo);
        if (carrera == null) {
            return "redirect:/carreras/buscar";
        }
        model.addAttribute("carrera", carrera);
        return "Carrera/modificar";
    }
    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute Carrera carrera) {
        CarreraCollection.modificarCarrera(carrera);
        return "redirect:/carreras/listar";
    }
}

