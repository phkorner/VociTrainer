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


    public void weatherClick(){

        DatabaseHandler.getDBReader().newChapter("Weather.txt");

        MainApplication.closeChapterStage();

    }

    public void sportsClick(){

    }

    public void professionsClick(){

    }

    public void foodClick(){

    }

    public void familyClick(){

    }



}
