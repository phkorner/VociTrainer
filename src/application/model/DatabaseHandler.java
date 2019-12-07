package src.application.model;

public class DatabaseHandler {

    static Database Woerterbuch;

    public static Database getDBReader() {
        Woerterbuch = Woerterbuch == null ? new Database() : Woerterbuch;
        return Woerterbuch;
    }



}
