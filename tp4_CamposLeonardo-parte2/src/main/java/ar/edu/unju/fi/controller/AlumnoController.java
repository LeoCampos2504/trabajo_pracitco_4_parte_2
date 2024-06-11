package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alumnos", AlumnoCollection.listarAlumnos());
        return "Alumno/listar";
    }

    @GetMapping("/alta")
    public String alta(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "Alumno/alta";
    }

    @PostMapping("/alta")
    public String alta(@ModelAttribute Alumno alumno) {
        AlumnoCollection.agregarAlumno(alumno);
        return "redirect:/alumnos/listar";
    }

    @GetMapping("/baja/{dni}")
    public String baja(@PathVariable String dni) {
        AlumnoCollection.eliminarAlumno(dni);
        return "redirect:/alumnos/listar";
    }

    @GetMapping("/buscar-modificar")
    public String mostrarFormularioBuscarModificar() {
        return "Alumno/buscar-modificar";
    }

    @PostMapping("/buscar-modificar")
    public String buscarModificar(@RequestParam String dni, Model model) {
        Alumno alumno = AlumnoCollection.buscarAlumno(dni);
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
            return "Alumno/modificar";
        } else {
            return "redirect:/alumnos/listar";  // Redirigir a listar si no se encuentra el alumno
        }
    }
    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Alumno alumno) {
        AlumnoCollection.modificarAlumno(alumno);
        return "redirect:/alumnos/listar";
    }


    @GetMapping("/eliminar")
    public String mostrarEliminarFormulario(Model model) {
        model.addAttribute("dni", "");
        return "Alumno/eliminar";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam String dni) {
        AlumnoCollection.eliminarAlumno(dni);
        return "redirect:/alumnos/listar";
    }
}
