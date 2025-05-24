package co.edu.uniquindio.proyectofinalprogramacion.viewController;

import co.edu.uniquindio.proyectofinalprogramacion.App;
import co.edu.uniquindio.proyectofinalprogramacion.controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class LoginViewController {
    LoginController login;
    App app;
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private MenuButton menuTipoUsuari;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField txtIdUsuario;
    @FXML
    private void seleccionarAdministrador(ActionEvent event){
        menuTipoUsuari.setText("Administrador");
    }
    @FXML
    private void seleccionarMedico(ActionEvent event){
        menuTipoUsuari.setText("Medico");
    }
    @FXML
    private void seleccionarPaciente(ActionEvent event){
        menuTipoUsuari.setText("Paciente");
    }

    public boolean existeUser(){
        boolean estado=login.exiteUser(menuTipoUsuari.getText(),txtIdUsuario.getText());
        return estado;

    }
    @FXML
    void rediriVistaUser(){

        if(existeUser()){

        }else{

        }

    }


}
