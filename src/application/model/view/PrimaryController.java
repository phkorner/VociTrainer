package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import src.application.model.FileSave;
import src.application.model.MainApplication;
import src.application.model.DatabaseHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
    private boolean correctAnswer = false;

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
            correctAnswer = true;
            highlightCorrectAnswer(1);
        } else {
            highlightWrongAnswer(1);
        }

        //load new question
        ArrayList<String> verteiler = DatabaseHandler.getDBReader().loadNewQuestion();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));
    }

    public void handleclick2() {

        //evaluate answer
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal2.getText())) {
            correctAnswer = true;
            highlightCorrectAnswer(2);
        } else {
            highlightWrongAnswer(2);
        }

        //load new question
        ArrayList<String> verteiler = DatabaseHandler.getDBReader().loadNewQuestion();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));
    }

    public void handleclick3() {

        //evaluate answer
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal3.getText())) {
            correctAnswer = true;
            highlightCorrectAnswer(3);
        } else {
            highlightWrongAnswer(3);
        }

        //load new question
        ArrayList<String> verteiler = DatabaseHandler.getDBReader().loadNewQuestion();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));
    }

    public void handleclick4() {

        //evaluate answer
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal4.getText())) {
            correctAnswer = true;
            highlightCorrectAnswer(4);
        } else {
            highlightWrongAnswer(4);
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

    public void handleclick6()  {
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

    public void highlightCorrectAnswer(int buttonId) {

        if (buttonId == 1) {
            proposal1.setStyle("-fx-background-color: #00CC00");
        } else if (buttonId == 2) {
            proposal2.setStyle("-fx-background-color: #00CC00");
        } else if (buttonId == 3) {
            proposal3.setStyle("-fx-background-color: #00CC00");
        } else if (buttonId == 4) {
            proposal4.setStyle("-fx-background-color: #00CC00");
        }

        proposal1.setStyle("-fx-background-color: lightgrey");
        proposal2.setStyle("-fx-background-color: lightgrey");
        proposal3.setStyle("-fx-background-color: lightgrey");
        proposal4.setStyle("-fx-background-color: lightgrey");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
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
        proposal1.setStyle("-fx-background-color: lightgrey");
        proposal2.setStyle("-fx-background-color: lightgrey");
        proposal3.setStyle("-fx-background-color: lightgrey");
        proposal4.setStyle("-fx-background-color: lightgrey");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}




