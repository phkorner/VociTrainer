package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import src.application.model.DatabaseHandler;
import src.application.model.MainApplication;

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

    // Loads new questions to the topic weather
    public void weatherClick(){
        DatabaseHandler.getDBReader().newChapter("Weather.txt");
        MainApplication.closeChapterStage();
    }

    // Loads new questions to the topic sports
    public void sportsClick(){
        DatabaseHandler.getDBReader().newChapter("Sports.txt");
        MainApplication.closeChapterStage();
    }

    // Loads new questions to the topic professions
    public void professionsClick(){
        DatabaseHandler.getDBReader().newChapter("Professions.txt");
        MainApplication.closeChapterStage();
    }

    // Loads new questions to the topic food
    public void foodClick(){
        DatabaseHandler.getDBReader().newChapter("Food.txt");
        MainApplication.closeChapterStage();
    }

    // Loads new questions to the topic family
    public void familyClick(){
        DatabaseHandler.getDBReader().newChapter("Family.txt");
        MainApplication.closeChapterStage();
    }
}
