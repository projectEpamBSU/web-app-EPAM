package main.java.user.stuff;

import main.java.component.Appointment;
import main.java.component.Treatment;
import main.java.user.Patient;
import main.java.userdb.DoctorDB;
import main.java.userdb.PatientDB;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Doctor implements Serializable {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String login;
    private String password;
    private String department;
    private boolean isHeadOfDepartment;
    private Set<Appointment> appointments;

    public Doctor() {}

    public Doctor(String name, String surname, int age, String login, String password, String department, boolean isHeadOfDepartment) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.department = department;
        this.isHeadOfDepartment = isHeadOfDepartment;
    }

    public String showProfile() {
        return "Name: " + name + '\n' + "Surname: " + surname + '\n' + "Age: " + age + '\n' + "Department: " + department + '\n' + "Login: " + login + '\n';
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public boolean getIsHeadOfDepartment() {
        return isHeadOfDepartment;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setIsHeadOfDepartment(boolean headOfDepartment) {
        isHeadOfDepartment = headOfDepartment;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setTreatmentToPatient(Treatment treatment) {
        (new PatientDB()).writeTreatment(treatment);
    }

    public void setRecoverToPatient(Patient patient, boolean isRecovered) {
        (new PatientDB()).writeIsRecovered(patient, isRecovered);
    }

    public String getPatientAppointments() {
        DoctorDB doctorDB = new DoctorDB();
        return doctorDB.getAppointments(this);
    }

    @Override
    public String toString() {
        return "[" + showProfile() + "]" + " " + department + " " + isHeadOfDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return getId() == doctor.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
