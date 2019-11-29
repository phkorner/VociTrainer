package src.application.model.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.application.model.DBReader;
import src.application.model.FileSave;

public class Controller {

    // instance variables
    public Button proposal1;
    public Button proposal2;
    public Button proposal3;
    public Button proposal4;
    private DBReader Woerterbuch;

    //constructor
    public Controller() {
        this.Woerterbuch = new DBReader();
    }

    public void handleclick1(){ proposal1.setText(Woerterbuch.getRandomWrongAnswer()); }

    public void handleclick2(){
        proposal2.setText(Woerterbuch.getRandomWrongAnswer());
    }

    public void handleclick3(){
        proposal3.setText(Woerterbuch.getRandomWrongAnswer());
    }

    public void handleclick4(){
        proposal4.setText(Woerterbuch.getRandomWrongAnswer());
    }

    public void handleclick5()  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Please login...");
            stage.setScene(new Scene(root1));
            stage.showAndWait();
        }catch (Exception e){
            System.out.println("Cannot start Login Page");
        }

    }

    public void loaddata(){
        return;
    }

    public void savedata(){
        FileSave.fileSave();
    }
}



