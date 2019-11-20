package src.application.model.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class Login {

    public static void login() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Please log in");

        VBox layout = new VBox(10);
        layout.getChildren().addAll();

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}


