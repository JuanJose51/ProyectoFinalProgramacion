package co.edu.uniquindio.proyectofinalprogramacion.viewController;

import co.edu.uniquindio.proyectofinalprogramacion.App;
import co.edu.uniquindio.proyectofinalprogramacion.controller.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

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
    private ActionEvent actionEvent;

    public void setApp(App app) {
        this.app = app;
        this.login = new LoginController(App.hospital);
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

    public void ingresarUsuario(ActionEvent actionEvent) {
        if (!existeUser()) {
            System.out.println("Usuario no válido.");
            return;
        }

        String tipoUsuario = menuTipoUsuari.getText();

        try {
            FXMLLoader loader = new FXMLLoader();

            switch (tipoUsuario) {
                case "Administrador":
                    loader.setLocation(App.class.getResource("AdministradorView.fxml"));
                    break;
                case "Medico":
                    loader.setLocation(App.class.getResource("MedicoView.fxml"));
                    break;
                case "Paciente":
                    loader.setLocation(App.class.getResource("PacienteView.fxml"));
                    break;
                default:
                    System.out.println("Tipo de usuario no seleccionado.");
                    return;
            }

            Parent root = loader.load();
            Scene nuevaEscena = new Scene(root);
            app.getPrimaryStage().setScene(nuevaEscena);
            app.getPrimaryStage().show();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("No se pudo cargar la vista del usuario: " + tipoUsuario);
        }
    }


    public void registrarCliente(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("RegistroUsuario.fxml"));
            Parent root = loader.load();

            Scene nuevaEscena = new Scene(root);
            app.getPrimaryStage().setScene(nuevaEscena);
            app.getPrimaryStage().show();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("No se pudo cargar la vista RegistroUsuario.fxml");
        }
    }

    public Button getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(Button btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(Button btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public ActionEvent getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
    }
}
