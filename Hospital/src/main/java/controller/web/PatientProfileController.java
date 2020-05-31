package main.java.controller.web;

import main.java.user.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientProfileController {
    @GetMapping(value = {"/patient/patient_profile"})
    public String getPatientMenu(Model model) {
        // get existing patient from db lately
        Patient patient = new Patient("Kek", "Kekw", 20, "kek", "kek", true);
        model.addAttribute("patientProfile", patient.showProfile());
        return "patient_profile";
    }
}
