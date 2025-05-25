package co.edu.uniquindio.proyectofinalprogramacion.viewController;

import co.edu.uniquindio.proyectofinalprogramacion.App;
import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Paciente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class PacienteViewController {

    private App app;
    private Paciente paciente;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblId;

    @FXML
    private Label lblCorreo;

    @FXML
    private Button btnVerHistorial;

    @FXML
    private Button btnAgendarCita;

    @FXML
    private Button btnCerrarSesion;

    /**
     * Este método debe llamarse después de cargar la vista y antes de mostrarla.
     */
    public void inicializar(App app, Paciente paciente) {
        this.app = app;
        this.paciente = paciente;

        // Mostrar la información del paciente en los labels
        lblNombre.setText("Nombre: " + paciente.getNombre());
        lblId.setText("ID: " + paciente.getId());
        lblCorreo.setText("Correo: " + paciente.getCorreo());
    }

    @FXML
    private void verHistorial(ActionEvent event) {
        // Aquí puedes implementar la lógica para mostrar una nueva ventana con el historial médico
        System.out.println("Mostrando historial médico de: " + paciente.getNombre());
    }

    @FXML
    private void agendarCita(ActionEvent event) {
        // Aquí puedes implementar la lógica para abrir el agendamiento de citas
        System.out.println("Agendando cita para: " + paciente.getNombre());
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        // Cerrar sesión y volver al login
        app.getPrimaryStage().close(); // opcional
        app.start(new javafx.stage.Stage()); // reinicia la app desde login
    }
}
