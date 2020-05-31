package main.java.controller.web;

import main.java.controller.resource_controller.Authorizer;
import main.java.form.SignInForm;
import main.java.user.Patient;
import main.java.user.stuff.Doctor;
import main.java.user.stuff.Nurse;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("signInForm")
public class SignInController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping(value = "/signin")
    public String getSignInForm(Model model) {
        model.addAttribute("signInForm", new SignInForm());
        return "signin";
    }

    @PostMapping(value = "/signin")
    public String signUp(@ModelAttribute(value="signInForm") SignInForm signInForm, Model model, HttpSession session) {
        model.addAttribute("signInForm", signInForm);

        System.out.println("login " + signInForm.getLogin());
        System.out.println("password " + signInForm.getPassword());

        String login = signInForm.getLogin();
        String password = signInForm.getPassword();

        Authorizer authorizer = new Authorizer();
        try {
            Object foundUser = authorizer.logIn(login, password);

            model.addAttribute("user", foundUser);
            session.setAttribute("user", foundUser);

            if (foundUser instanceof Patient) {
                return "redirect:patient";
            }
            else if (foundUser instanceof Doctor) {
                return "redirect:doctor";
            }
            else if (foundUser instanceof Nurse) {
                return "redirect:nurse";
            }
            else {
                System.out.println("Something wrong with the found user");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return "redirect:patient";
    }
}
