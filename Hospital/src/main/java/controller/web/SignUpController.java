package main.java.controller.web;

import main.java.controller.resource_controller.Authorizer;
import main.java.form.SignUpForm;
import main.java.user.Patient;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SignUpController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping(value = "/signup")
    public String getSignUpForm(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String signUp(@ModelAttribute(value="signUpForm") SignUpForm signUpForm, HttpSession session, Model model) {
        System.out.println("name " + signUpForm.getName());
        System.out.println("surname " + signUpForm.getSurname());
        System.out.println("age " + Integer.parseInt(signUpForm.getAge()));
        System.out.println("login " + signUpForm.getLogin());
        System.out.println("password " + signUpForm.getPassword());

        String name = signUpForm.getName();
        String surname = signUpForm.getSurname();
        int age = Integer.parseInt(signUpForm.getAge());
        String login = signUpForm.getLogin();
        String password = signUpForm.getPassword();

        Authorizer authorizer = new Authorizer();
        Patient newPatient = authorizer.signUp(name, surname, age, login, password);
        model.addAttribute("user", newPatient);
        session.setAttribute("user", newPatient);

        return "redirect:patient";
    }
}
