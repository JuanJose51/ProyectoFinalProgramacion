package co.edu.uniquindio.proyectofinalprogramacion.viewController;

import co.edu.uniquindio.proyectofinalprogramacion.controller.CitaController;
import co.edu.uniquindio.proyectofinalprogramacion.model.citas.Cita;
import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Medico;
import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;

public class CitaViewController {

    @FXML private TextField txtId;
    @FXML private DatePicker dateFecha;
    @FXML private TextField txtMotivo;
    @FXML private ComboBox<Medico> comboMedico;
    @FXML private ComboBox<Paciente> comboPaciente;
    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> colId;
    @FXML private TableColumn<Cita, String> colFecha;
    @FXML private TableColumn<Cita, String> colMotivo;
    @FXML private TableColumn<Cita, String> colMedico;
    @FXML private TableColumn<Cita, String> colPaciente;

    private final CitaController citaController = new CitaController();

    @FXML
    public void initialize() {
        cargarCombos();
        configurarTabla();
        cargarDatosTabla();
    }

    private void cargarCombos() {
        comboMedico.setItems(FXCollections.observableArrayList(citaController.obtenerMedicos()));
        comboPaciente.setItems(FXCollections.observableArrayList(citaController.obtenerPacientes()));
    }

    private void configurarTabla() {
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCita()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCita().toString()));
        colMotivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivo()));
        colMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedico().getNombre()));
        colPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaciente().getNombre()));
    }

    private void cargarDatosTabla() {
        tablaCitas.setItems(FXCollections.observableArrayList(citaController.listarCitas()));
    }

    @FXML
    private void crearCita() {
        String id = txtId.getText();
        LocalDateTime fecha = dateFecha.getValue().atStartOfDay();
        String motivo = txtMotivo.getText();
        Medico medico = comboMedico.getValue();
        Paciente paciente = comboPaciente.getValue();

        Cita nuevaCita = new Cita(id, fecha, paciente, medico, motivo);
        citaController.crearCita(nuevaCita);
        cargarDatosTabla();
        limpiarFormulario();
    }

    @FXML
    private void actualizarCita() {
        Cita seleccionada = tablaCitas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            seleccionada.setFechaCita(dateFecha.getValue().atStartOfDay());
            seleccionada.setMotivo(txtMotivo.getText());
            seleccionada.setMedico(comboMedico.getValue());
            seleccionada.setPaciente(comboPaciente.getValue());

            citaController.actualizarCita(seleccionada);
            cargarDatosTabla();
            limpiarFormulario();
        }
    }

    @FXML
    private void eliminarCita() {
        Cita seleccionada = tablaCitas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            citaController.eliminarCita(seleccionada.getIdCita());
            cargarDatosTabla();
            limpiarFormulario();
        }
    }

    @FXML
    private void seleccionarCita() {
        Cita seleccionada = tablaCitas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            txtId.setText(seleccionada.getIdCita());
            dateFecha.setValue(seleccionada.getFechaCita().toLocalDate());
            txtMotivo.setText(seleccionada.getMotivo());
            comboMedico.setValue(seleccionada.getMedico());
            comboPaciente.setValue(seleccionada.getPaciente());
        }
    }

    private void limpiarFormulario() {
        txtId.clear();
        dateFecha.setValue(null);
        txtMotivo.clear();
        comboMedico.getSelectionModel().clearSelection();
        comboPaciente.getSelectionModel().clearSelection();
    }
}
