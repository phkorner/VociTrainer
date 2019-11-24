package src.application.model.view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {

    public Button proposal1;
    public Button proposal2;
    public Button proposal3;
    public Button proposal4;

    public void handleclick1(){
        proposal1.setText("test");
    }

    public void handleclick2(){
        proposal2.setText("test");
    }

    public void handleclick3(){
        proposal3.setText("test");
    }

    public void handleclick4(){
        proposal4.setText("test");
    }

    public void login(){

        Login start = new Login();
    }
}



