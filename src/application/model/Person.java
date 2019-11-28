package src.application.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person, to Store the User-Data.
 * Input based on Java FX Scene Builder Tutorial
 * @author Philipp Korner
 */

public class Person {

    private final StringProperty userName;
    private final StringProperty password;
    private final StringProperty repeatPassword;


    /**
     * Constructor with some initial data.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.userName = new SimpleStringProperty(firstName);

        // Some initial dummy data, just for convenient testing.
        this.password = new SimpleStringProperty("password");
        this.repeatPassword = new SimpleStringProperty("Repeat password");

    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String firstName) {
        this.userName.set(firstName);
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword.get();
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword.set(repeatPassword);
    }

    public StringProperty repeatPasswordProperty() {
        return repeatPassword;
    }
}
