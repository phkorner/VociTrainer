package src.application.model;

import java.util.Observable;

public class Login extends Observable {

    private String username;
    private String password;
    private String filepath;

    public Login() {
        this.username = "";
        this.password = "";
        this.filepath = "src/application/model/Users.txt"; //todo: method for filepath

    }

    public String getFilepath() {
        return filepath;
    }
}
