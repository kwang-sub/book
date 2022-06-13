package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.AuthInfo;
import spring.AuthService;
import spring.WrongIdPasswordException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private AuthService authService;

    public LoginController(@Autowired AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String form(@ModelAttribute LoginCommand loginCommand) {
        return "login/loginForm";
    }

    @PostMapping
    public String submit(@Valid @ModelAttribute LoginCommand loginCommand, Errors errors, HttpSession session) {
        if (errors.hasErrors()) {
            return "login/loginForm";
        }
        try{
            AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
            session.setAttribute("authInfo", authInfo);
            return "login/loginSuccess";
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
}