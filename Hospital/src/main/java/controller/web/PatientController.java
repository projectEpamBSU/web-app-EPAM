package main.java.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @GetMapping(value = {"/patient"})
    public String getPatientMenu() {
        return "/patient";
    }
}
