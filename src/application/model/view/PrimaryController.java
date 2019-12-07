package src.application.model.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.application.model.FileSave;
import src.application.model.MainApplication;
import src.application.model.DatabaseHandler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PrimaryController implements Observer {

    // instance variables
    public Button proposal1;
    public Button proposal2;
    public Button proposal3;
    public Button proposal4;
    public Label course;
    public Label word;
    public static Stage stage;
    public static Label userName;

    //constructor
    public PrimaryController() {
    }

    @FXML
    private void initialize() {

        //register as observer for database
        DatabaseHandler.getDBReader().addObserver(this);

        course.setText(DatabaseHandler.getDBReader().getFilename());

    }

    public void handleclick(){

        ArrayList<String> verteiler = DatabaseHandler.getDBReader().evaluate();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));

    }

    public void handleclick5()  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = fxmlLoader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Please login...");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cannot start Login Page");
            e.printStackTrace();
        }

    }

    public void loaddata(){
        return;
    }

    public void savedata(){
        FileSave.fileSave();
    }

    public void close(){
        MainApplication.close();
    }

    public static void closeLogin(){
        stage.close();
        
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}




