package main.java.controller.web;

import main.java.user.stuff.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorProfileController {
    @GetMapping(value = {"/doctor/doctor_profile"})
    public String getPatientMenu(Model model) {
        // get existing doctor from db lately
        Doctor doctor = new Doctor("Kek", "Kekw", 20, "Kek", "kek", "Surgical", false);
        model.addAttribute("doctorProfile", doctor.showProfile());
        return "doctor_profile";
    }
}
