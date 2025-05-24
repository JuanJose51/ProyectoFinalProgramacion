package co.edu.uniquindio.proyectofinalprogramacion;

import co.edu.uniquindio.proyectofinalprogramacion.model.hospital.Hospital;
import co.edu.uniquindio.proyectofinalprogramacion.model.personas.Administrador;
import co.edu.uniquindio.proyectofinalprogramacion.viewController.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;


    static Administrador administrador = new Administrador("1", "pedro", "admin@gmail.com.co", "311");
    public static Hospital hospital = new Hospital("Hospital rapidaAtencion", administrador);
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Página Principal");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Login.fxml"));
            VBox rootLayout = loader.load();

            LoginViewController loginViewController = loader.getController();
            loginViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("No se pudo cargar la vista Login.fxml");
        }
    }
}