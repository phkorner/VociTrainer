package src.application.model.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.application.model.MainApplication;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class LoginController implements Observer {
    public Stage window = new Stage();
    public AnchorPane rootLayout2;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public String filepath = "src/application/model/Users.txt";
    public static Stage stage;
    private static Scanner x;

    /*
    @Override
    public void start(Stage window) {

        try {
            this.window = window;
            this.window.setTitle("Please log in...");
            this.window.initModality(Modality.APPLICATION_MODAL);

            initRootLayout2();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    public void initRootLayout2() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("/src/application/model/view/Login.fxml"));
            rootLayout2 = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout2);

            window.setScene(scene);
            window.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNewAccount()  {
        Stage stage = new Stage();
        stage = MainApplication.loadnewAccountStage();
        
    }

    //todo: move to Login.java file?
    public void verifyLogin()  {

        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found){
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.getText().trim()) && tempPassword.trim().equals(password.getText().trim())){
                    found = true;
                }
            }
            PrimaryController.closeLogin();

            // Show Login confirmation message.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login for user " + username.getText() + " successful");
            alert.setHeaderText("Login successful");
            alert.setContentText("Login successful");
            alert.showAndWait();

        }catch (Exception e){
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Username or Passwod");
            alert.setHeaderText("Invalid Username or Password - Please correct");
            alert.setContentText("Invalid Username or Password - Please correct");

            alert.showAndWait();
            e.printStackTrace();
        }

    }

    public static void closeCreateNewAccountStage(){
        stage.close();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void enterClicked() {
        password.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    verifyLogin();
                }
            }
        });
    }
}



