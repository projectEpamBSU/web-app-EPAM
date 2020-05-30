package main.java.controller.resource_controller;

import main.java.user.Patient;
import main.java.user.stuff.Doctor;
import main.java.user.stuff.Nurse;

import java.util.ArrayList;
import java.util.Scanner;

public class Authorizer {

    private DBReader dbReader;
    private DBUpdater dbUpdater;

    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Nurse> nurses;
    private Scanner scanner;

    public Authorizer() {
        this.dbReader = new DBReader();
        this.dbUpdater = new DBUpdater();

        this.patients = this.dbReader.getAllPatients();
        this.doctors = this.dbReader.getAllDoctors();
        this.nurses = this.dbReader.getAllNurses();

        this.scanner = new Scanner(System.in);
    }

    public Object findUserByLoginAndPassword(String login, String password) {
        for(Patient patient: this.patients) {
            if(login.equals(patient.getLogin()) && password.equals(patient.getPassword())) {
                return patient;
            }
        }

        for(Doctor doctor: this.doctors) {
            if(login.equals(doctor.getLogin()) && password.equals(doctor.getPassword())) {
                return doctor;
            }
        }

        for(Nurse nurse: this.nurses) {
            if(login.equals(nurse.getLogin()) && password.equals(nurse.getPassword())) {
                return nurse;
            }
        }

        return new Object();
    }

    public Object logIn() throws Exception {
        final int LOG_IN_ATTEMPTS = 3;
        String login, password;
        for(int i = 0; i < LOG_IN_ATTEMPTS; i ++) {
            System.out.println("login: ");
            login = this.scanner.nextLine();
            System.out.println("password: ");
            password = this.scanner.nextLine();

            Object foundUser = this.findUserByLoginAndPassword(login, password);
            if(!(foundUser.equals(new Object()))) {
                return foundUser;
            }
            else {
                System.out.println("Error: incorrect login or password, try again");
            }
        }

        throw new Exception("You are out of attempts");
    }

    /*public Patient signUp() {
        System.out.println("Name: ");
        String name = this.scanner.nextLine();

        System.out.println("Surname: ");
        String surname = this.scanner.nextLine();

        System.out.println("Age: ");
        String ageStr = this.scanner.nextLine();
        int age = Integer.parseInt(ageStr);

        System.out.println("Your login: ");
        String login = this.scanner.nextLine();

        System.out.println("Your password: ");
        String password = this.scanner.nextLine();

        Patient newPatient = new Patient(name, surname, age, login, password, true);
        this.dbUpdater.addPatient(newPatient);

        return newPatient;
    }*/

    public Patient signUp() {
        System.out.println("kekw");
        return new Patient();
    }

    public Patient signUp(String name, String surname, int age, String login, String password) {
        Patient newPatient = new Patient(name, surname, age, login, password, true);
        this.dbUpdater.addPatient(newPatient);

        return newPatient;
    }
}
