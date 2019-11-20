package src.application.model.view;

import javafx.scene.control.Button;

public class Controller {

    public Button proposal1;
    public Button proposal2;
    public Button proposal3;
    public Button proposal4;
    public Button login;



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
        Login.login();
    }
}



