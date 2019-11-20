package src.application.model.view;

import javafx.scene.control.Button;

public class Controller {

    public Button proposal1;
    public Button proposal2;
    public Button proposal3;
    public Button proposal4;

    public void handleclick1(){
        System.out.println("well done");
        proposal1.setText("test");
    }

    public void handleclick2(){
        System.out.println("well done");
        proposal2.setText("test");
    }

    public void handleclick3(){
        System.out.println("well done");
        proposal3.setText("test");
    }

    public void handleclick4(){
        System.out.println("well done");
        proposal4.setText("test");
    }
}
