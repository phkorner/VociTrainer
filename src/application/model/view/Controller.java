package src.application.model.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {

    public Button proposal1;
    public Button proposal2;
    public Button proposal3;
    public Button proposal4;
    public Button login;
    private Stage window;

    public void handleclick1(){
        proposal1.setText("test");
    }

    public void handleclick2(){
        proposal2.setText("test");
    }

    public void handleclick3(){
        proposal3.setText("test");
    }

    public void handleclick4(){
        proposal4.setText("test");
    }

    public void handleclick5()  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Please login...");
            stage.setScene(new Scene(root1));
            stage.showAndWait();
        }catch (Exception e){
            System.out.println("Cannot start Login Page");
        }

    }
}



