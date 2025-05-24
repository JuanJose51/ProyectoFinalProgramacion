package co.edu.uniquindio.proyectofinalprogramacion.viewController;

import co.edu.uniquindio.proyectofinalprogramacion.App;
import co.edu.uniquindio.proyectofinalprogramacion.controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class LoginViewController {

    private LoginController login;
    private App app;

    @FXML
    private MenuButton menuTipoUsuari;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtIdUsuario;

    public void setApp(App app) {
        this.app = app;
        this.login = new LoginController(app.hospital);
    }

    @FXML
    private void seleccionarAdministrador(ActionEvent event) {
        menuTipoUsuari.setText("Administrador");
    }

    @FXML
    private void seleccionarMedico(ActionEvent event) {
        menuTipoUsuari.setText("Medico");
    }

    @FXML
    private void seleccionarPaciente(ActionEvent event) {
        menuTipoUsuari.setText("Paciente");
    }

    public boolean existeUser() {
        return login.exiteUser(menuTipoUsuari.getText(), txtIdUsuario.getText());
    }

    @FXML
    private void onIngresarClicked(ActionEvent event) {
        if (existeUser()) {
            System.out.println("Usuario válido. ¡Ingresando!");
        } else {
            System.out.println("Usuario no válido.");
        }
    }
}
