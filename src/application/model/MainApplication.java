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
    private static Stage loginStage;
    private static Stage newAccountStage;
    private static Stage changeAccount;
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
    public void fileUploadwithSelection (){
        return;
    }

    public static void close(){
        primaryStage.close();
    }


    public static Stage loadLoginStage(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/Login.fxml"));
            Parent root1 = fxmlLoader.load();
            loginStage = new Stage();
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.setTitle("Please login...");
            loginStage.setScene(new Scene(root1));
            loginStage.show();
        }catch (Exception e){
            System.out.println("Cannot start Login Page");
            e.printStackTrace();
        }
        return null;
    }


    public static Stage loadnewAccountStage(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/NewAccount.fxml"));
            Parent root1 = fxmlLoader.load();
            newAccountStage = new Stage();
            newAccountStage.initModality(Modality.APPLICATION_MODAL);
            newAccountStage.setTitle("Create a new User- Account");
            newAccountStage.setScene(new Scene(root1));
            newAccountStage.show();
        }catch (Exception e){
            System.out.println("Cannot load Page");
            e.printStackTrace();
        }
        return null;
    }

    public static void closeLogin(){
        loginStage.close();
    }

    public static void closeCreateNewAccountStage(){
        newAccountStage.close();
    }

    public static void closeChangeAccount(){
        changeAccount.close();
    }
}
