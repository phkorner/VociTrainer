package src.application.model;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class MainApplication extends Application {

    private static Stage primaryStage;
    private static Stage chapterStage;
    private AnchorPane rootLayout;
    private AnchorPane login;



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


            // initialize the RootLayout and the Woerterbuch DBReader
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
            loader.setLocation(MainApplication.class.getResource("view/PrimaryStage.fxml"));
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

    public static void close(){
        primaryStage.close();
    }


    public static Stage  LoadChapterStage(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/Chapter.fxml"));
            Parent root1 = fxmlLoader.load();
            chapterStage= new Stage();
            chapterStage.initModality(Modality.APPLICATION_MODAL);
            chapterStage.setTitle("Please select Chapter:");
            chapterStage.setScene(new Scene(root1));
            chapterStage.show();
        }catch (Exception e){
            System.out.println("Cannot load Page");
            e.printStackTrace();
        }
        return null;
    }

    public static void closeChapterStage(){
        chapterStage.close();
    }

}
