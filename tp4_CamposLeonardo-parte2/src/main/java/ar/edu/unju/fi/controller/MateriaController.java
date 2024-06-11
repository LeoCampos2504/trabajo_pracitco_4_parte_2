package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("materias", MateriaCollection.listarMaterias());
        return "Materia/listar";
    }

    @GetMapping("/alta")
    public String alta(Model model) {
        model.addAttribute("docentes", DocenteCollection.listarDocentes());
        model.addAttribute("carreras", CarreraCollection.listarCarreras());
        model.addAttribute("materia", new Materia());
        return "Materia/alta";
    }

    @PostMapping("/alta")
    public String alta(@ModelAttribute Materia materia, @RequestParam("docente.legajo") String docenteLegajo, @RequestParam("carrera.codigo") String carreraCodigo) {
        Docente docente = DocenteCollection.buscarDocentePorLegajo(docenteLegajo);
        Carrera carrera = CarreraCollection.buscarCarreraPorCodigo(carreraCodigo);
        
        if (docente != null && carrera != null) {
            materia.setDocente(docente);
            materia.setCarrera(carrera);
            MateriaCollection.agregarMateria(materia);
            return "redirect:/materias/listar";
        } else {
            return "Materia/alta";
        }
    }


    @GetMapping("/baja")
    public String mostrarFormularioEliminar() {
        return "Materia/eliminar";
    }

    @PostMapping("/baja")
    public String baja(@RequestParam String codigo) {
        MateriaCollection.eliminarMateria(codigo);
        return "redirect:/materias/listar";
    }

    @GetMapping("/buscar")
    public String buscarCarrera() {
        return "Materia/buscar-materia";
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar(@RequestParam String codigo, Model model) {
        Materia materia = MateriaCollection.buscarMateria(codigo);
        if (materia == null) {
            return "redirect:/docentes/buscar";
        }
        model.addAttribute("materia", materia);
        model.addAttribute("docentes", DocenteCollection.listarDocentes());
        model.addAttribute("carreras", CarreraCollection.listarCarreras());
        return "Materia/modificar";
    }
    @PostMapping("/modificar")
    public String procesarFormularioAlta(@ModelAttribute Materia materia, @RequestParam("docente.legajo") String docenteLegajo, @RequestParam("carrera.codigo") String carreraCodigo) {
        Docente docente = DocenteCollection.buscarDocentePorLegajo(docenteLegajo);
        Carrera carrera = CarreraCollection.buscarCarreraPorCodigo(carreraCodigo);
        
        if (docente != null && carrera != null) {
            materia.setDocente(docente);
            materia.setCarrera(carrera);
            MateriaCollection.modificarMateria(materia);
            return "redirect:/materias/listar";
        } else {
            // Aquí puedes manejar el caso en que el docente o la carrera no se encuentren
            // Por ejemplo, puedes agregar un mensaje de error al modelo y mostrarlo en la vista
            return "Materia/alta";
        }
    }

}
