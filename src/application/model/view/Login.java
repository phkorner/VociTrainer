package src.application.model.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.application.model.MainApplication;
import java.io.IOException;
import src.application.model.view.Controller;


public class Login extends Application {
    public Stage window = new Stage();
    public AnchorPane rootLayout2;

    @Override
    public void start(Stage window) throws Exception {

        try {
            this.window = window;
            this.window.setTitle("Please log in...");
            this.window.initModality(Modality.APPLICATION_MODAL);

            initRootLayout2();

            // Login- Layout.show();

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
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create a new User- Account");
            stage.setScene(new Scene(root1));
            stage.showAndWait();
        }catch (Exception e){
            System.out.println("Cannot load Page");
        }

    }

    public void logintoAccount()  {
        try {

        }catch (Exception e){
            System.out.println("Cannot load Page");
        }

    }
}



