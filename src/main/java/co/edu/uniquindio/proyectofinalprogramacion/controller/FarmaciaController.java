package co.edu.uniquindio.proyectofinalprogramacion.controller;

import co.edu.uniquindio.proyectofinalprogramacion.model.farmacia.Farmacia;

import java.util.ArrayList;
import java.util.List;

public class FarmaciaController {
    private List<Farmacia> farmacias;

    public FarmaciaController() {
        this.farmacias = new ArrayList<>();
    }

    public void agregarFarmacia(Farmacia farmacia) {
        farmacias.add(farmacia);
    }

    public List<Farmacia> obtenerTodasLasFarmacias() {
        return new ArrayList<>(farmacias);
    }

    public Farmacia buscarFarmaciaPorId(int id) {
        for (Farmacia farmacia : farmacias) {
            if (farmacia.getId() == id) {
                return farmacia;
            }
        }
        return null;
    }

    public boolean actualizarFarmacia(Farmacia farmaciaActualizada) {
        for (int i = 0; i < farmacias.size(); i++) {
            if (farmacias.get(i).getId() == farmaciaActualizada.getId()) {
                farmacias.set(i, farmaciaActualizada);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarFarmacia(int id) {
        return farmacias.removeIf(farmacia -> farmacia.getId() == id);
    }
}