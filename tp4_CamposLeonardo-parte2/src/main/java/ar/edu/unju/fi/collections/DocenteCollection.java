package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Docente;
import java.util.ArrayList;
import java.util.List;

public class DocenteCollection {
    private static List<Docente> docentes = new ArrayList<>();

    public static void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    public static List<Docente> listarDocentes() {
        return docentes;
    }

    public static Docente buscarDocentePorLegajo(String legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo().equals(legajo)) {
                return docente;
            }
        }
        return null;
    }
    
    public static Docente buscarDocente(String legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo().equals(legajo)) {
                return docente;
            }
        }
        return null;
    }

    public static void modificarDocente(Docente docenteModificado) {
        for (int i = 0; i < docentes.size(); i++) {
            if (docentes.get(i).getLegajo().equals(docenteModificado.getLegajo())) {
                docentes.set(i, docenteModificado);
                break;
            }
        }
    }


    public static void eliminarDocente(String legajo) {
        docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
    }
}
