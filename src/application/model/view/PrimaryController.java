package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import src.application.model.MainApplication;
import src.application.model.DatabaseHandler;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PrimaryController implements Observer {

    @FXML
    private Button proposal1;
    @FXML
    private Button proposal2;
    @FXML
    private Button proposal3;
    @FXML
    private Button proposal4;
    @FXML
    private Label ratio;
    @FXML
    private Label questions;
    @FXML
    private Label correctAnswers;
    @FXML
    private Label course;
    @FXML
    private Label word;
    private String style;
    private int intQuestions;
    private int intCorrectAnswers;
    private int intRatio;

    public PrimaryController() {
        DatabaseHandler.getDBReader().addObserver(this);
    }

    /**
     * set up for first question (called automatically by FXML)
     */
    @FXML
    private void initialize() {

        course.setText(DatabaseHandler.getDBReader().getFilename());
        resetProgress();

        ArrayList<String> verteiler = DatabaseHandler.getDBReader().loadNewQuestion();
        proposal1.setText(verteiler.get(0));
        proposal2.setText(verteiler.get(1));
        proposal3.setText(verteiler.get(2));
        proposal4.setText(verteiler.get(3));
        word.setText(verteiler.get(4));
    }

    /**
     * handle button click on answer button 1
     */
    public void handleclick1() {
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal1.getText())) {
            highlightCorrectAnswer(1);
        } else {
            highlightWrongAnswer(1);
        }
    }

    /**
     * handle button click on answer button 2
     */
    public void handleclick2() {
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal2.getText())) {
            highlightCorrectAnswer(2);
        } else {
            highlightWrongAnswer(2);
        }
    }

    /**
     * handle button click on answer button 3
     */
    public void handleclick3() {
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal3.getText())) {
            highlightCorrectAnswer(3);
        } else {
            highlightWrongAnswer(3);
        }
    }

    /**
     * handle button click on answer button 4
     */
    public void handleclick4() {
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal4.getText())) {
            highlightCorrectAnswer(4);
        } else {
            highlightWrongAnswer(4);
        }
    }

    /**
     * handles the button "next question".
     * only does something when an answer has been given! (in that case: update progress & loadNewQuestion
     */
    public void handleclick5() {

        if (proposal1.getStyle().equals("-fx-background-color: #00CC00") ||
                proposal2.getStyle().equals("-fx-background-color: #00CC00") ||
                proposal3.getStyle().equals("-fx-background-color: #00CC00") ||
                proposal4.getStyle().equals("-fx-background-color: #00CC00") ) {
            this.intQuestions++;
            this.intRatio = (intCorrectAnswers * 100) / intQuestions;
            questions.setText(Integer.toString(intQuestions));
            correctAnswers.setText(Integer.toString(intCorrectAnswers));
            ratio.setText(intRatio + " %");
            loadNewQuestion();
        }
    }

    /**
     * Loads a new chapter based on the selection of the user
     */
    public void loaddata(){
        MainApplication.LoadChapterStage();
    }

    /**
     * Closes the whole application
     */
    public void close(){
        MainApplication.close();
    }

    /**
     * Color change of the button clicked to green, if the answer is correct
     */
    private void highlightCorrectAnswer(int buttonId)  {
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
        this.intCorrectAnswers++; // update the correct answer integer for progress bar
    }

    /**
     * Color change of the button clicked to red, if the answer is correct and
     * color change of the button which provides the correct answer
     */
    private void highlightWrongAnswer(int buttonId){
        if (buttonId == 1) {
            proposal1.setStyle("-fx-background-color: #FF6633");
        } else if (buttonId == 2) {
            proposal2.setStyle("-fx-background-color: #FF6633");
        } else if (buttonId == 3) {
            proposal3.setStyle("-fx-background-color: #FF6633");
        } else if (buttonId == 4) {
            proposal4.setStyle("-fx-background-color: #FF6633");
        }

        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal1.getText())) { proposal1.setStyle("-fx-background-color: #00CC00"); }
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal2.getText())) { proposal2.setStyle("-fx-background-color: #00CC00"); }
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal3.getText())) { proposal3.setStyle("-fx-background-color: #00CC00"); }
        if (DatabaseHandler.getDBReader().evaluateAnswer(proposal4.getText())) { proposal4.setStyle("-fx-background-color: #00CC00"); }
    }

    /**
     * loads a new question from database (woerterbuch)
     */
    private void loadNewQuestion(){
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

    /**
     * initial and reset of progress bar and loads new question
     */
    public void resetProgress() {
        this.intQuestions = 0;
        this.intCorrectAnswers = 0;
        this.intRatio = 0;
        questions.setText("0");
        correctAnswers.setText("0");
        ratio.setText("n/a");
        loadNewQuestion();
    }

    /**
     * called when a new chapter is loaded in the database (woerterbuch) to update primary stage.
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        course.setText(DatabaseHandler.getDBReader().getFilename());
        resetProgress(); //includes loadNewQuestion()
    }

    //getter methods required for testing
    public int getIntQuestions() { return intQuestions; }
    public int getIntCorrectAnswers() { return intCorrectAnswers; }
    public int getIntRatio() { return intRatio; }
}




