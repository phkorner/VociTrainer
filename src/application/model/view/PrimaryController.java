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
    @FXML
    private Button proposal1;
    @FXML
    private Button proposal2;
    @FXML
    private Button proposal3;
    @FXML
    private Button proposal4;
    @FXML
    private Label course;
    @FXML
    private Label word;
    public static Stage stage;
    @FXML
    private static Label userName;

    /**
     * constructor
     */

    public PrimaryController() {
    }

    @FXML
    private void initialize() {
        //register as observer for database
        DatabaseHandler.getDBReader().addObserver(this);
        course.setText(DatabaseHandler.getDBReader().getFilename());
    }

    /**
     * Called when the user clicks on one of the answer buttons. It checkes if the answer is correct and returns green (correct) or red (false).
     * It also brings the next question to the screen.
     */

    public void handleclick(){

        ArrayList<String> verteiler = DatabaseHandler.getDBReader().evaluate();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));

    }

    /**
     * Called when the user clicks on Login in the menue or on the Person icon in the top right corner.
     */

    public void handleclick5()  {
        Stage stage = new Stage();
        stage = MainApplication.loadLoginStage();
    }

    /**
     * Called when the user clicks on Account - change password.
     */

    public void handleclick6()  {
        Stage stage = new Stage();
        stage = MainApplication.loadChangeAccountStage();
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


    @Override
    public void update(Observable o, Object arg) {

    }
}




