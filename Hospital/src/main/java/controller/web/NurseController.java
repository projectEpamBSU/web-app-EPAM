package main.java.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NurseController {
    @GetMapping(value = {"/nurse"})
    public String getNurseMenu() {
        return "/nurse";
    }
}
