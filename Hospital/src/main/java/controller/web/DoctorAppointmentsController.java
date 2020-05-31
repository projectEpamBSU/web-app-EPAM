package main.java.controller.web;

import main.java.component.Appointment;
import main.java.user.stuff.Doctor;
import main.java.userdb.DoctorDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class DoctorAppointmentsController {
    @GetMapping(value = {"/doctor/doctor_appointments"})
    public String getPatientMenu(Model model, HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("user");
        DoctorDB doctorDB = new DoctorDB();
        ArrayList<Appointment> plannedAppointments = doctorDB.getDbReader()
                .getPlannedAppointmentsByDoctor(doctor);
        model.addAttribute("doctorAppointments", plannedAppointments);

        return "doctor_appointments";
    }
}
