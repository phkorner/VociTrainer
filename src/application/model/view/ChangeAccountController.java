package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.application.model.MainApplication;

import java.io.File;
import java.util.Scanner;

public class ChangeAccountController {

    @FXML
    private Label username;
    @FXML
    private TextField oldPassword;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField repeatNewPassword;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    public String filepath = "src/application/model/Users.txt";
    private static Scanner x;
    private Stage dialogStage = new Stage();


    /**
     * Called when the user clicks "cancel" in the change-account window.
     */
    @FXML
    private void handleCancel() {

        MainApplication.closeChangeAccount();
    }


    /**
     * Called when the user clicks "Save" in the change-account window.
     */
    @FXML
    private void handleSave(){

        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.getText().trim()) && tempPassword.trim().equals(oldPassword.getText().trim())){
                    found = true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        isInputValid();


        // Show Login confirmation message.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Password for user " + username.getText() + " successfully changed");
        alert.setHeaderText("Password change successful");
        alert.setContentText("Password change successful");
        alert.showAndWait();

    }

            /**
             * Validates the user input in the text fields.
             *
             * @return true if the input is valid
             */
            public boolean isInputValid() {
            String errorMessage = "";

            if (newPassword.getText() == null || newPassword.getText().length() == 0) {
                errorMessage += "No valid password!\n";
            }

            if (repeatNewPassword.getText() == null || repeatNewPassword.getText().length() == 0) {
                errorMessage += "No valid password repetition!\n";
            }

            if (newPassword.getText() == repeatNewPassword.getText()){
                errorMessage += "Your password entries are not identical\n";
            }


            if (errorMessage.length() == 0) {
                return true;
            } else {
                // Show the error message.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText(errorMessage);

                alert.showAndWait();

                return false;
            }
        }

}



