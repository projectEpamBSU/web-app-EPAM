package main.java.controller.web;

import main.java.user.stuff.Nurse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NurseProfileController {
    @GetMapping(value = {"/nurse/nurse_profile"})
    public String getPatientMenu(Model model) {
        // get existing nurse from db lately
        Nurse nurse = new Nurse("Kek", "Kekw", 20, "kek", "kek");
        model.addAttribute("nurseProfile", nurse.showProfile());
        return "nurse_profile";
    }
}
