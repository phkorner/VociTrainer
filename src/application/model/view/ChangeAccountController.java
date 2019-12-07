package src.application.model.view;

import javafx.fxml.FXML;
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


    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {

       // MainApplication.closeCreateNewAccountStage();
    }

    @FXML
    private void handleSave(){
        //TODO
    }


}
