package main.java.controller.web;

import main.java.user.stuff.Nurse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class NurseProfileController {
    @GetMapping(value = {"/nurse/nurse_profile"})
    public String getPatientMenu(Model model, HttpSession session) {
        Nurse nurse = (Nurse) session.getAttribute("user");
        model.addAttribute("nurseProfile", nurse.showProfile());
        return "nurse_profile";
    }
}
