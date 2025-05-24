package co.edu.uniquindio.proyectofinalprogramacion.model.interfaces;

import co.edu.uniquindio.proyectofinalprogramacion.model.citas.Cita;

import java.util.List;

public interface GestionCitas {
    void solicitarCita(Cita cita);
    void cancelarCita(Cita cita);
    List<Cita> listarCitas();
}