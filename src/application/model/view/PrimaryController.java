package src.application.model.view;

import javafx.animation.PauseTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    private Button nextButton;
    @FXML
    private Label course;
    @FXML
    private Label word;
    public static Stage stage;
    private String style;




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

    public void handleclick1() {

        //evaluate answer
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal1.getText())) {
            highlightCorrectAnswer(1);
        } else {
            highlightWrongAnswer(1);
        }


    }

    public void handleclick2() {

        //evaluate answer
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal2.getText())) {
            highlightCorrectAnswer(2);
        } else {
            highlightWrongAnswer(2);
        }
    }

    public void handleclick3() {

        //evaluate answer
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal3.getText())) {
            highlightCorrectAnswer(3);
        } else {
            highlightWrongAnswer(3);
        }
    }

    public void handleclick4() {

        //evaluate answer
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal4.getText())) {
            highlightCorrectAnswer(4);
        } else {
            highlightWrongAnswer(4);
        }
    }


    public void loaddata(){
        Stage stage = new Stage();
        stage = MainApplication.LoadChapterStage();
    }

    public void close(){
        MainApplication.close();
    }

    public void highlightCorrectAnswer(int buttonId)  {
        style = proposal1.getStyle();
        if (buttonId == 1) {
            proposal1.setStyle("-fx-background-color: #00CC00");
        } else if (buttonId == 2) {
            proposal2.setStyle("-fx-background-color: #00CC00");
        } else if (buttonId == 3) {
            proposal3.setStyle("-fx-background-color: #00CC00");
        } else if (buttonId == 4) {
            proposal4.setStyle("-fx-background-color: #00CC00");
        }
    }

    public void highlightWrongAnswer(int buttonId){

        if (buttonId == 1) {
            proposal1.setStyle("-fx-background-color: #FF6633");
        } else if (buttonId == 2) {
            proposal2.setStyle("-fx-background-color: #FF6633");
        } else if (buttonId == 3) {
            proposal3.setStyle("-fx-background-color: #FF6633");
        } else if (buttonId == 4) {
            proposal4.setStyle("-fx-background-color: #FF6633");
        }
    }

    public void loadNewQuestion(){
        proposal1.setStyle(style);
        proposal2.setStyle(style);
        proposal3.setStyle(style);
        proposal4.setStyle(style);
        ArrayList<String> verteiler = DatabaseHandler.getDBReader().loadNewQuestion();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));
    }
}




