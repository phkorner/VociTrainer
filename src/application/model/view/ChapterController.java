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

    public void weatherClick(){
        DatabaseHandler.getDBReader().newChapter("Weather.txt");
        MainApplication.closeChapterStage();
    }

    public void sportsClick(){
        DatabaseHandler.getDBReader().newChapter("Sports.txt");
        MainApplication.closeChapterStage();
    }

    public void professionsClick(){
        DatabaseHandler.getDBReader().newChapter("Professions.txt");
        MainApplication.closeChapterStage();
    }

    public void foodClick(){
        DatabaseHandler.getDBReader().newChapter("Food.txt");
        MainApplication.closeChapterStage();
    }

    public void familyClick(){
        DatabaseHandler.getDBReader().newChapter("Family.txt");
        MainApplication.closeChapterStage();
    }
}
