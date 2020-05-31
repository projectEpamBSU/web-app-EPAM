package main.java.controller.web;

import main.java.user.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PatientProfileController {
    @GetMapping(value = {"/patient/patient_profile"})
    public String getPatientMenu(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("user");
        model.addAttribute("patientProfile", patient.showProfile());
        return "patient_profile";
    }
}
