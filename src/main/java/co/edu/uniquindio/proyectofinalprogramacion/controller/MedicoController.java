package co.edu.uniquindio.proyectofinalprogramacion.controller;

import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoController {
    private final List<Medico> medicos;

    public MedicoController() {
        this.medicos = new ArrayList<>();
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public List<Medico> obtenerTodosLosMedicos() {
        return new ArrayList<>(medicos);
    }

    public Medico buscarMedicoPorId(String id) {
        for (Medico medico : medicos) {
            if (medico.getId().equals(id)) {
                return medico;
            }
        }
        return null;
    }

    public boolean actualizarMedico(Medico medicoActualizado) {
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getId().equals(medicoActualizado.getId())) {
                medicos.set(i, medicoActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarMedico(String id) {
        return medicos.removeIf(medico -> medico.getId().equals(id));
    }
}
