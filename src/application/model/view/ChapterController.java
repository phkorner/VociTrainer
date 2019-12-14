package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import src.application.model.DatabaseHandler;
import src.application.model.MainApplication;

import java.awt.*;

public class ChapterController {

    @FXML
    Button weather;
    @FXML
    Button sports;
    @FXML
    Button professions;
    @FXML
    Button food;
    @FXML
    Button family;


    // loads a new chapter which has questions about weather
    public void weatherClick(){

        DatabaseHandler.getDBReader().newChapter("Weather.txt");

        MainApplication.closeChapterStage();
    }

    // loads a new chapter which has questions about sports
    public void sportsClick(){

    }

    // loads a new chapter which has questions about professions
    public void professionsClick(){

    }

    // loads a new chapter which has questions about food
    public void foodClick(){

    }

    // loads a new chapter which has questions about family and relationship
    public void familyClick(){

    }
}
