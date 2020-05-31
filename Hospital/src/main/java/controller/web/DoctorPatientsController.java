package main.java.controller.web;

import main.java.user.stuff.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DoctorPatientsController {
    @GetMapping(value = {"/doctor/doctor_patients"})
    public String getPatientMenu(Model model, HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("user");
        model.addAttribute("patients", doctor.getPatientAppointments());

        return "doctor_patients";
    }
}
