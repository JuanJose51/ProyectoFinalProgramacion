package co.edu.uniquindio.proyectofinalprogramacion.controller;

import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private final List<Paciente> pacientes;

    public PacienteController() {
        this.pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return new ArrayList<>(pacientes);
    }

    public Paciente buscarPacientePorId(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null;
    }

    public boolean actualizarPaciente(Paciente pacienteActualizado) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId().equals(pacienteActualizado.getId())) {
                pacientes.set(i, pacienteActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPaciente(String id) {
        return pacientes.removeIf(paciente -> paciente.getId().equals(id));
    }
}