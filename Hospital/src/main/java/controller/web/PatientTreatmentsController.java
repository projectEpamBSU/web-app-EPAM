package main.java.controller.web;

import main.java.component.Treatment;
import main.java.user.Patient;
import main.java.userdb.PatientDB;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class PatientTreatmentsController {
    @GetMapping(value = {"/patient/patient_treatments"})
    public String getPatientMenu(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("user");
        PatientDB patientDB = new PatientDB();
        ArrayList<Treatment> treatments = patientDB.getTreatmentsByPatient(patient);
        model.addAttribute("patientTreatments", treatments);

        return "patient_treatments";
    }
}
