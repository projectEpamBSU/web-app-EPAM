package main.java.controller.web;

import main.java.controller.resource_controller.Authorizer;
import main.java.form.SignInForm;
import main.java.form.SignUpForm;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("signInForm")
public class SignInController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping(value = "/signin")
    public String getSignUpForm(Model model) {
        model.addAttribute("signInForm", new SignUpForm());
        return "signin";
    }

    @PostMapping(value = "/signin")
    public String signUp(@ModelAttribute(value="signInForm") SignInForm signInForm, BindingResult result, Model model) {
        model.addAttribute("signInForm", signInForm);

        System.out.println("login " + signInForm.getLogin());
        System.out.println("password " + signInForm.getPassword());

        String login = signInForm.getLogin();
        String password = signInForm.getPassword();

        Authorizer authorizer = new Authorizer();

        // return menu page according to the role lately
        return "index";
    }
}
