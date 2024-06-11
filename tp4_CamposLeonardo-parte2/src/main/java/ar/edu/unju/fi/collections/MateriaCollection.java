package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Materia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MateriaCollection {
    private static List<Materia> materias = new ArrayList<>();

    public static void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public static List<Materia> listarMaterias() {
        return materias;
    }

    public static Materia buscarMateria(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equals(codigo)) {
                return materia;
            }
        }
        return null;
    }

    public static void modificarMateria(Materia materiaModificada) {
        
        Iterator<Materia> iterator = materias.iterator();
        while (iterator.hasNext()) {
            Materia materia = iterator.next();
           
            if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
                
                iterator.remove();
               
                materias.add(materiaModificada);
                break;
            }
        }
    }


    public static void eliminarMateria(String codigo) {
        materias.removeIf(materia -> materia.getCodigo().equals(codigo));
    }
}
