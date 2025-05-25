package co.edu.uniquindio.proyectofinalprogramacion.controller;

import co.edu.uniquindio.proyectofinalprogramacion.model.citas.Cita;
import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Medico;
import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CitaController {
    private final List<Cita> citas;
    private final List<Cita> listaCitas = new ArrayList<>();
    private final List<Medico> listaMedicos = new ArrayList<>();
    private final List<Paciente> listaPacientes = new ArrayList<>();

    public CitaController() {
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> obtenerTodasLasCitas() {
        return new ArrayList<>(citas);
    }

    public Cita buscarCitaPorId(String id) {
        for (Cita cita : citas) {
            if (Objects.equals(cita.getId(), id)) {
                return cita;
            }
        }
        return null;
    }

    public boolean actualizarCita(Cita citaActualizada) {
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getId().equals(citaActualizada.getId())) {
                citas.set(i, citaActualizada);
                return true;
            }
        }
        return false;
    }

    public void eliminarCita(String idCita) {
        listaCitas.removeIf(cita -> cita.getIdCita().equals(idCita));
    }
    public List<Medico> obtenerMedicos() {
        return listaMedicos;
    }

    public List<Paciente> obtenerPacientes() {
        return listaPacientes;
    }

    public List<Cita> listarCitas() {
        return listaCitas;
    }

    public void crearCita(Cita nuevaCita) {
        listaCitas.add(nuevaCita);
    }
}