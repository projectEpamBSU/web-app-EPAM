package main.java.controller.web;

import main.java.component.Appointment;
import main.java.user.stuff.Nurse;
import main.java.userdb.NurseDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class NurseAppointmentsController {
    @GetMapping(value = {"/nurse/nurse_appointments"})
    public String getPatientMenu(Model model, HttpSession session) {
        Nurse nurse = (Nurse) session.getAttribute("user");
        NurseDB nurseDB = new NurseDB();
        ArrayList<Appointment> plannedAppointments = nurseDB.getDbReader().getAppointmentsByNurse(nurse);
        model.addAttribute("nurseAppointments", plannedAppointments);

        return "nurse_appointments";
    }
}
