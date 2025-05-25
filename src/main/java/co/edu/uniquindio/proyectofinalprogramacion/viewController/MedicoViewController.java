package co.edu.uniquindio.proyectofinalprogramacion.viewController;

import co.edu.uniquindio.proyectofinalprogramacion.App;
import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Medico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MedicoViewController {

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblEspecialidad;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblId;

    @FXML
    private Button btnVerCitas;

    @FXML
    private Button btnCerrarSesion;

    private App app;
    private Medico medico;

    public void inicializar(App app, Medico medico) {
        this.app = app;
        this.medico = medico;

        lblNombre.setText("Nombre: " + medico.getNombre());
        lblEspecialidad.setText("Especialidad: " + medico.getEspecialidad());
        lblCorreo.setText("Correo: " + medico.getCorreo());
        lblId.setText("ID: " + medico.getId());
    }

    @FXML
    private void verCitas() {
        // Aquí puedes mostrar una ventana con la lista de citas del médico
        System.out.println("Citas del médico " + medico.getNombre());
    }

    @FXML
    private void cerrarSesion() {
        app.start(app.getPrimaryStage());
    }

    public void setLblNombre(Label lblNombre) {
        this.lblNombre = lblNombre;
    }

    public void setLblEspecialidad(Label lblEspecialidad) {
        this.lblEspecialidad = lblEspecialidad;
    }

    public void setLblCorreo(Label lblCorreo) {
        this.lblCorreo = lblCorreo;
    }

    public void setLblId(Label lblId) {
        this.lblId = lblId;
    }

    public void setBtnVerCitas(Button btnVerCitas) {
        this.btnVerCitas = btnVerCitas;
    }

    public Button getBtnVerCitas() {
        return btnVerCitas;
    }

    public void setBtnCerrarSesion(Button btnCerrarSesion) {
        this.btnCerrarSesion = btnCerrarSesion;
    }

    public Button getBtnCerrarSesion() {
        return btnCerrarSesion;
    }
}
