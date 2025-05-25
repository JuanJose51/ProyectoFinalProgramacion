package co.edu.uniquindio.proyectofinalprogramacion.controller;

import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoController {
    private List<Medico> medicos;

    public MedicoController() {
        this.medicos = new ArrayList<>();
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public List<Medico> obtenerTodosLosMedicos() {
        return new ArrayList<>(medicos);
    }

    public Medico buscarMedicoPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }

    public boolean actualizarMedico(Medico medicoActualizado) {
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getId() == medicoActualizado.getId()) {
                medicos.set(i, medicoActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarMedico(int id) {
        return medicos.removeIf(medico -> medico.getId() == id);
    }
}
