package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import src.application.model.FileSave;
import src.application.model.MainApplication;
import src.application.model.DatabaseHandler;
import java.util.ArrayList;

public class PrimaryController {

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

    //constructor
    public PrimaryController() {
    }

    /*
     * set up for first question (called automatically by FXML)
     */
    @FXML
    private void initialize() {

        course.setText(DatabaseHandler.getDBReader().getFilename());

        ArrayList<String> verteiler = DatabaseHandler.getDBReader().loadNewQuestion();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));
    }

    public void handleclick() {

        //evaluate answer //todo: any button not just 1!
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal1.getText())) {
            //todo: approval highlight. correct
            System.out.println("congrats! correct.");
        } else {
            //todo: highlight the correct answer instead! wrong
            System.out.println("that's wrong!");
        }

        //load new question
        ArrayList<String> verteiler = DatabaseHandler.getDBReader().loadNewQuestion();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));

    }

    public void handleclick5()  {
        Stage stage = new Stage();
        stage = MainApplication.loadLoginStage();
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
}




