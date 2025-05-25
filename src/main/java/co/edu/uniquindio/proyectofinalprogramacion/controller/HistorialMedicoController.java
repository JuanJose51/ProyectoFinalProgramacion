package co.edu.uniquindio.proyectofinalprogramacion.controller;


import co.edu.uniquindio.proyectofinalprogramacion.model.citas.HistorialMedico;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedicoController {
    private List<HistorialMedico> historiales;

    public HistorialMedicoController() {
        this.historiales = new ArrayList<>();
    }

    public void agregarHistorial(HistorialMedico historial) {
        historiales.add(historial);
    }

    public List<HistorialMedico> obtenerTodosLosHistoriales() {
        return new ArrayList<>(historiales);
    }

    public HistorialMedico buscarHistorialPorId(int id) {
        for (HistorialMedico historial : historiales) {
            if (historial.getId() == id) {
                return historial;
            }
        }
        return null;
    }

    public boolean actualizarHistorial(HistorialMedico historialActualizado) {
        for (int i = 0; i < historiales.size(); i++) {
            if (historiales.get(i).getId() == historialActualizado.getId()) {
                historiales.set(i, historialActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarHistorial(int id) {
        return historiales.removeIf(historial -> historial.getId() == id);
    }
}
