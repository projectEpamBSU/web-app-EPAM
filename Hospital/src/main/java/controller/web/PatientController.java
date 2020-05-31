package main.java.controller.web;

import main.java.user.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @GetMapping(value = {"/patient"})
    public String getPatientMenu(Model model) {
        return "/patient";
    }
}
