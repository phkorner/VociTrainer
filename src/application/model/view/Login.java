package src.application.model.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.application.model.MainApplication;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Login extends Application {
    public Stage window = new Stage();
    public AnchorPane rootLayout2;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public String filepath = "src/application/model/Users.txt";

    private static Scanner x;

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewAccount.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create a new User- Account");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cannot load Page");
            e.printStackTrace();
        }
    }

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
            Controller.closeLogin();
            System.out.println("Login successfully!");

        }catch (Exception e){
            System.out.println("User or password is wrong.");
            e.printStackTrace();
        }

    }
}



