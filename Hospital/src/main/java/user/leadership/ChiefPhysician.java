package main.java.user.leadership;

import main.java.user.stuff.Doctor;
import main.java.userdb.DoctorDB;

public class ChiefPhysician {

    private String name;
    private String surname;
    private int age;
    private String login;
    private String password;

    public ChiefPhysician(String name, String surname, int age, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public void appointDepHead(Doctor doctor){
        DoctorDB doctorDB = new DoctorDB();
        doctorDB.writeIsDepartmentHead(doctor);
        doctorDB.shutdown();
    }
}
