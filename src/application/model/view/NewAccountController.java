package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.application.model.MainApplication;
import src.application.model.Person;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;


public class NewAccountController {

    @FXML
    private TextField userNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField repeatPasswordField;


    private Person person;
    private boolean okClicked = false;
    private Stage dialogStage;
    public String filepath = "Users.txt";

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    // Reference to the main application.
    private Login login;

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setUserName(userNameField.getText());
            person.setPassword(passwordField.getText());
            person.setRepeatPassword(repeatPasswordField.getText());

            saveRecord(userNameField,passwordField,filepath);

            login.window.close();
            //dialogStage.close();
        }
    }

    public static void saveRecord(TextField userNameField, TextField passwordField, String filepath){
        try {
            FileWriter createAccount = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(createAccount);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(userNameField+","+passwordField);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "User Account has been created");

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "User Account has not been created");
        }
    }


    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        login.window.close();
        //dialogStage.close();
    }


    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (userNameField.getText() == null || userNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }

        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "No valid password!\n";
        }

        if (repeatPasswordField.getText() == null || repeatPasswordField.getText().length() == 0) {
            errorMessage += "No valid password repetition!\n";
        }

        if (passwordField.getText() != repeatPasswordField.getText()){
            errorMessage += "Your password entries are not identical\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}




