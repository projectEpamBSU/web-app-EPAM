package main.java.controller.resource_controller;

import main.java.dbconnection.SessionProvider;
import main.java.tasklog.NurseTaskLog;
import main.java.user.Patient;
import main.java.user.stuff.Doctor;
import main.java.component.Appointment;
import main.java.component.Treatment;

import main.java.user.stuff.Nurse;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;

public class DBUpdater {
    private SessionProvider sessionProvider = new SessionProvider();
    private Session session;

    public DBUpdater(Session session) {
        this.session = session;
    }

    public DBUpdater() {
        this.session = this.sessionProvider.getSessionFactory().openSession();
    }

    public void deleteNurseTaskLogRowById(int id) {
        session.beginTransaction();

        NurseTaskLog deletedNurseTaskLog = (NurseTaskLog) session.load(NurseTaskLog.class, id);
        session.delete(deletedNurseTaskLog);

        session.getTransaction().commit();
    }

    public void deleteNurseTaskLogByAppointmentAndNurse(Appointment appointment, Nurse nurse) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(NurseTaskLog.class);
        criteria.add(Restrictions.eq("appointment", appointment));
        criteria.add(Restrictions.eq("nurse", nurse));

        session.getTransaction().commit();

        this.deleteNurseTaskLogRowById(((NurseTaskLog) criteria.list().get(0)).getId());
    }

    public void addPatient(Patient newPatient) {
        session.beginTransaction();

        String hql = "insert into Patient(name, surname, age, login, password, recovered) select" +
                ":name, :surname, :age, :login, :password, :recovered from Patient";
        Query query = session.createQuery(hql);
        query.setParameter("name", newPatient.getName());
        query.setParameter("surname", newPatient.getSurname());
        query.setParameter("age", newPatient.getAge());
        query.setParameter("login", newPatient.getLogin());
        query.setParameter("password", newPatient.getPassword());
        query.setParameter("recovered", newPatient.getRecovered());
        query.executeUpdate();

//        session.save(newPatient);
        session.getTransaction().commit();
    }

    public void addAppointment(Appointment newAppointment) {
        session.beginTransaction();

        session.save(newAppointment);
        session.save(new Treatment(newAppointment, "", "", "", ""));

        session.getTransaction().commit();
    }

    public void addRowToNurseTaskLog(NurseTaskLog nurseTaskLog) {
        session.beginTransaction();
        session.save(nurseTaskLog);
        session.getTransaction().commit();
    }

    public void updatePatient(Patient updatedPatient) {
        session.beginTransaction();

        String updatePatientQuery = "UPDATE Patient set name= :name," +
                "surname= :surname," +
                "age= :age," +
                "login= :login," +
                "password= :password," +
                "recovered= :recovered WHERE id= :patientId";
        Query query = session.createQuery(updatePatientQuery);
        query.setString("name", updatedPatient.getName());
        query.setString("surname", updatedPatient.getSurname());
        query.setInteger("age", updatedPatient.getAge());
        query.setString("login", updatedPatient.getLogin());
        query.setString("password", updatedPatient.getPassword());
        query.setBoolean("recovered", updatedPatient.isRecovered());
        query.setInteger("patientId", updatedPatient.getId());

        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void updateDoctor(Doctor updatedDoctor) {
        session.beginTransaction();

        String updateDoctorQuery = "UPDATE Doctor set name= :name," +
                "surname= :surname," +
                "age= :age," +
                "login= :login," +
                "password= :password," +
                "department= :department," +
                "isHeadOfDepartment= :isHeadOfDepartment WHERE id= :doctorId";
        Query query = session.createQuery(updateDoctorQuery);
        query.setString("name", updatedDoctor.getName());
        query.setString("surname", updatedDoctor.getSurname());
        query.setInteger("age", updatedDoctor.getAge());
        query.setString("login", updatedDoctor.getLogin());
        query.setString("password", updatedDoctor.getPassword());
        query.setString("department", updatedDoctor.getDepartment());
        query.setBoolean("isHeadOfDepartment", updatedDoctor.getIsHeadOfDepartment());
        query.setInteger("doctorId", updatedDoctor.getId());

        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void updateTreatment(Treatment updatedTreatment) {
        session.beginTransaction();

        String updateTreatmentQuery = "UPDATE Treatment set procedure= :procedure," +
                "medicine= :medicine," +
                "operation= :operation," +
                "diagnose= :diagnose WHERE id= :id";
        Query query = session.createQuery(updateTreatmentQuery);
        query.setString("procedure", updatedTreatment.getProcedure());
        query.setString("medicine", updatedTreatment.getMedicine());
        query.setString("operation", updatedTreatment.getOperation());
        query.setString("diagnose", updatedTreatment.getDiagnose());
        query.setInteger("id", updatedTreatment.getId());

        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void changeRecoveredStatusByPatient(Patient patient, boolean isRecovered) {
        session.beginTransaction();

        String updatePatientQuery = "UPDATE Patient set recovered= :recovered WHERE id= :patientId";
        Query query = session.createQuery(updatePatientQuery);
        query.setBoolean("recovered", isRecovered);
        query.setInteger("patientId", patient.getId());

        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void shutdown() {
        this.sessionProvider.shutdown();
    }
}
