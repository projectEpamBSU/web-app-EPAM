package main.java.controller.web;

import main.java.user.Patient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

public class PatientAppointmentsController {
    @GetMapping(value = {"/patient/patient_appointments"})
    public String getPatientMenu(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("user");
        model.addAttribute("patientAppointments", patient.getAppointments());

        return "patient_appointments";
    }
}
