package src.application.model;


import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class MainApplication extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    /*
     * main method to launch primary stage
     */
    public static void main(String [] args) {
        launch(args);
    }

    /*
     * required for javafx launch. starts and shows primaryStage
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("VociTrainer");


            initRootLayout();

            // primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * initializes the rootLayout from the VociTrainer.fxml file
     * built with SceneBuilder App
     * 
     * notice: make sure to have the same javafx version in .fxml file as in IDE compiler!
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("/src/application/model/view/PrimaryStage.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /*
     * tbd
     */
    public void fileUploadwithSelection (){
        return;
    }

}
