package main.java.userdb;

import main.java.controller.resource_controller.DBReader;
import main.java.controller.resource_controller.DBUpdater;
import main.java.user.stuff.Nurse;

import java.util.ArrayList;

public class NurseDB {
    private DBReader dbReader;
    private DBUpdater dbUpdater;

    public NurseDB() {
        this.dbReader = new DBReader();
        this.dbUpdater = new DBUpdater();
    }

    public DBReader getDbReader() {
        return dbReader;
    }

    public DBUpdater getDbUpdater() {
        return dbUpdater;
    }

    public ArrayList<Nurse> getAllNurses() {
        return this.dbReader.getAllNurses();
    }

    public void shutdown() {
        this.dbReader.shutdown();
        this.dbUpdater.shutdown();
    }
}
