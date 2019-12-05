package src.application.model.view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.application.model.view.Login;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


public class NewAccountController {

    @FXML
    private TextField userNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField repeatPasswordField;



    private boolean okClicked = false;
    private Stage dialogStage = new Stage();
    public String filepath = "src/application/model/Users.txt";

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    // Reference to the main application.
    private Login login = new Login();
    


    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {


            saveRecord(userNameField,passwordField,filepath);

           Login.closeCreateNewAccountStage();

        }
    }

    public static void saveRecord(TextField userNameField, TextField passwordField, String filepath){
        try {
            FileWriter createAccount = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(createAccount);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(userNameField.getText()+","+passwordField.getText());
            pw.flush();
            pw.close();

            Stage alertbox = new Stage();
            alertbox.initModality(Modality.APPLICATION_MODAL);
            alertbox.setTitle("Account-creatoin successful");
            alertbox.setMinWidth(350);
            alertbox.setMinHeight(120);

            Label label = new Label();
            label.setText("User Account has been created");

            Button closeButton = new Button("OK");
            closeButton.setOnAction(event -> alertbox.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            alertbox.setScene(scene);
            alertbox.showAndWait();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "User Account has not been created");
            e.printStackTrace();
        }
    }


    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {

        Login.closeCreateNewAccountStage();
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

        if (passwordField.getText() == repeatPasswordField.getText()){
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




