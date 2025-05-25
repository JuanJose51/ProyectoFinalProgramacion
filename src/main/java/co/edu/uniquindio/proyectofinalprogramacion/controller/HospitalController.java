package co.edu.uniquindio.proyectofinalprogramacion.controller;

import co.edu.uniquindio.proyectofinalprogramacion.model.hospital.Hospital;

import java.util.ArrayList;
import java.util.List;

public class HospitalController {
    private List<Hospital> hospitales;

    public HospitalController() {
        this.hospitales = new ArrayList<>();
    }

    public void agregarHospital(Hospital hospital) {
        hospitales.add(hospital);
    }

    public List<Hospital> obtenerTodosLosHospitales() {
        return new ArrayList<>(hospitales);
    }

    public Hospital buscarHospitalPorId(int id) {
        for (Hospital hospital : hospitales) {
            if (hospital.getId() == id) {
                return hospital;
            }
        }
        return null;
    }

    public boolean actualizarHospital(Hospital hospitalActualizado) {
        for (int i = 0; i < hospitales.size(); i++) {
            if (hospitales.get(i).getId() == hospitalActualizado.getId()) {
                hospitales.set(i, hospitalActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarHospital(int id) {
        return hospitales.removeIf(hospital -> hospital.getId() == id);
    }
}