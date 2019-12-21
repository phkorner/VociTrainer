package src.application.model;

public class DatabaseHandler {

    static Database Woerterbuch;

    /**
     * makes sure that there is always exactly one static database object called "Woerterbuch"
     * required for observer/observable pair.
     * @return Woerterbuch
     */
    public static Database getDBReader() {
        Woerterbuch = Woerterbuch == null ? new Database() : Woerterbuch;
        return Woerterbuch;
    }



}
