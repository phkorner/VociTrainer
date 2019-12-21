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

    /**
     * Loads new vocabulary from database and return to primary stage.
     * chapter: weather
     */
    public void weatherClick(){
        DatabaseHandler.getDBReader().newChapter("Weather.txt");
        MainApplication.closeChapterStage();
    }

    /**
     * Loads new vocabulary from database and return to primary stage.
     * chapter: sports
     */
    public void sportsClick(){
        DatabaseHandler.getDBReader().newChapter("Sports.txt");
        MainApplication.closeChapterStage();
    }

    /**
     * Loads new vocabulary from database and return to primary stage.
     * chapter: professions
     */
    public void professionsClick(){
        DatabaseHandler.getDBReader().newChapter("Professions.txt");
        MainApplication.closeChapterStage();
    }

    /**
     * Loads new vocabulary from database and return to primary stage.
     * chapter: food
     */
    public void foodClick(){
        DatabaseHandler.getDBReader().newChapter("Food.txt");
        MainApplication.closeChapterStage();
    }

    /**
     * Loads new vocabulary from database and return to primary stage.
     * chapter: family (= default!)
     */
    public void familyClick(){
        DatabaseHandler.getDBReader().newChapter("Family.txt");
        MainApplication.closeChapterStage();
    }
}
