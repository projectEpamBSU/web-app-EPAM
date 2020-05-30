package main.java.controller.web;

import main.java.controller.resource_controller.Authorizer;
import main.java.form.SignUpForm;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("signUpForm")
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
    public String signUp(@ModelAttribute(value="signUpForm") SignUpForm signUpForm, BindingResult result, Model model) {
        model.addAttribute("signUpForm", signUpForm);

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
        authorizer.signUp(name, surname, age, login, password);

        return "signup_success";
    }
}
