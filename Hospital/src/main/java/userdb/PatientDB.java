package main.java.userdb;

import main.java.controller.resource_controller.DBReader;
import main.java.controller.resource_controller.DBUpdater;
import main.java.component.Appointment;
import main.java.component.Treatment;
import main.java.user.Patient;

import java.util.ArrayList;

public class PatientDB {
    private DBReader dbReader;
    private DBUpdater dbUpdater;

    public PatientDB() {
        this.dbReader = new DBReader();
        this.dbUpdater = new DBUpdater();
    }

    public ArrayList<Patient> getAllPatients() {
        return this.dbReader.getAllPatients();
    }

    public Patient getPatient(String name, String surname) {
        return this.dbReader.getPatientByNameAndSurname(name, surname);
    }

    public void editPatient(Patient editedPatient) {
        this.dbUpdater.updatePatient(editedPatient);
    }

    public void writeAppointment(Appointment appointment) {
        this.dbUpdater.addAppointment(appointment);
    }

    public ArrayList<Treatment> getTreatmentsByPatient(Patient patient) {
        return this.dbReader.getTreatmentsByPatient(patient);
    }

    public void writeTreatment(Treatment treatment) {
        this.dbUpdater.updateTreatment(treatment);
    }

    public void writeIsRecovered(Patient patient, boolean isRecovered) {
        patient.setRecovered(isRecovered);
        this.editPatient(patient);
    }

    public void shutdown() {
        this.dbReader.shutdown();
        this.dbUpdater.shutdown();
    }
}