package co.edu.uniquindio.proyectofinalprogramacion.model.interfaces;

import co.edu.uniquindio.proyectofinalprogramacion.model.citas.HistorialMedico;

public interface ManejoHistorial {
    void registrarDiagnostico(HistorialMedico historial, String diagnostico, String tratamiento);
    void verHistorial(HistorialMedico historial);
}
