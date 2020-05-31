package main.java.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    @GetMapping(value = {"/doctor"})
    public String getDoctorMenu() {
        return "/doctor";
    }
}
