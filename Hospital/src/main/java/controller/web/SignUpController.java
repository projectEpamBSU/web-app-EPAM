package main.java.controller.web;

import main.java.controller.resource_controller.Authorizer;
import main.java.form.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {
    @RequestMapping(value = "/signup", method= RequestMethod.GET)
    public String getSignUpForm(Model model) {
        SignUpForm signUpForm = new SignUpForm();
        model.addAttribute(signUpForm);

        return "signUp";
    }

    @RequestMapping(value = "/signup", method= RequestMethod.POST)
    public String signUp(@ModelAttribute(value="signUpForm") SignUpForm signUpForm, Model model) {
        System.out.println("name " + signUpForm.getName());
        System.out.println("surname " + signUpForm.getSurname());
        System.out.println("age " + Integer.parseInt(signUpForm.getAge()));
        System.out.println("login " + signUpForm.getLogin());
        System.out.println("password " + signUpForm.getPassword());

        model.addAttribute(signUpForm);

        String name = signUpForm.getName();
        String surname = signUpForm.getSurname();
        int age = Integer.parseInt(signUpForm.getAge());
        String login = signUpForm.getLogin();
        String password = signUpForm.getPassword();

        Authorizer authorizer = new Authorizer();
        authorizer.signUp(name, surname, age, login, password);

        return "index";
    }
}
