package src.application.model.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.application.model.MainApplication;

import java.awt.*;
import java.io.IOException;

public class Login {
    Stage window = new Stage();
    private AnchorPane rootLayout2;

    public void login() throws Exception {

        //VBox layout = new VBox(10);
        //layout.getChildren().addAll();

        //Scene scene = new Scene(layout);
        //window.setScene(scene);
        //window.showAndWait();


        try {
            window = window;
            window.setTitle("Please log in...");
            window.initModality(Modality.APPLICATION_MODAL);

            initRootLayout2();

            // Login- Layout.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initRootLayout2() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("/src/application/model/view/Login.fxml"));
            rootLayout2 = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout2);

            window.setScene(scene);
            window.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


