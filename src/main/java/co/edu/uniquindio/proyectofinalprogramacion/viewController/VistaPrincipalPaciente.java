package co.edu.uniquindio.proyectofinalprogramacion.viewController;

import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VistaPrincipalPaciente {

    @FXML private TableView<Paciente> tablaPacientes;
    @FXML private TableColumn<Paciente, String> colId, colNombre, colTelefono, colEps, colTipoSangre;
    @FXML private TextField campoId, campoNombre, campoTelefono, campoEps, campoTipoSangre;

    private final ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colTelefono.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelefono()));
        colEps.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEps()));
        colTipoSangre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoSangre()));
        tablaPacientes.setItems(listaPacientes);
    }

    @FXML
    public void crearPaciente() {
        Paciente nuevo = new Paciente(
                campoId.getText(),
                campoNombre.getText(),
                campoTelefono.getText(),
                campoEps.getText(),
                campoTipoSangre.getText()
        );
        listaPacientes.add(nuevo);
        limpiarCampos();
    }

    @FXML
    public void eliminarPaciente() {
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaPacientes.remove(seleccionado);
        }
    }

    @FXML
    public void limpiarCampos() {
        campoId.clear();
        campoNombre.clear();
        campoTelefono.clear();
        campoEps.clear();
        campoTipoSangre.clear();
    }
}
