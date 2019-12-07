package src.application.model.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import src.application.model.MainApplication;

public class ChangeAccountController {

    @FXML
    private Label username;
    @FXML
    private TextField oldPassword;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField repeatOldPassword;
    @FXML
    private Button save;
    @FXML
    private Button cancel;


    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {

       MainApplication.closeChangeAccount();
    }

    @FXML
    private void handleSave(){
        //TODO
    }


}
