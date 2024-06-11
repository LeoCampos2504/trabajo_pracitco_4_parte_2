package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Carrera;
import java.util.ArrayList;
import java.util.List;

public class CarreraCollection {
    private static List<Carrera> carreras = new ArrayList<>();

    public static void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }
    

    public static List<Carrera> listarCarreras() {
        return carreras;
    }
    public static Carrera buscarCarreraPorCodigo(String codigo) {
        for (Carrera carrera : carreras) {
            if (carrera.getCodigo().equals(codigo)) {
                return carrera;
            }
        }
        return null;
    }
    public static Carrera buscarCarrera(String codigo) {
        for (Carrera carrera : carreras) {
            if (carrera.getCodigo().equals(codigo)) {
                return carrera;
            }
        }
        return null;
    }

    public static void modificarCarrera(Carrera carreraModificada) {
        for (int i = 0; i < carreras.size(); i++) {
            Carrera carrera = carreras.get(i);
            if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
                carreras.remove(i);
                carreras.add(i, carreraModificada);
                break;
            }
        }
    }


    public static void eliminarCarrera(String codigo) {
        carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
    }
}

