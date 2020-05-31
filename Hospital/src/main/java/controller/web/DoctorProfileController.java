package main.java.controller.web;

import main.java.user.Patient;
import main.java.user.stuff.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DoctorProfileController {
    @GetMapping(value = {"/doctor/doctor_profile"})
    public String getDoctorMenu(Model model, HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("user");
        model.addAttribute("doctorProfile", doctor.showProfile());
        return "doctor_profile";
    }
}
