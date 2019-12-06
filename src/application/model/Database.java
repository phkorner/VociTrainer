package src.application.model;

import src.application.model.DBReader;

public class Database {

    static DBReader Woerterbuch;

    public static DBReader getDBReader() {
        Woerterbuch = Woerterbuch == null ? new DBReader() : Woerterbuch;
        return Woerterbuch;
    }

}
