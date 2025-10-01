package com.mika.demo.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mika.demo.AuthenticationService;

@Controller
@SessionAttributes("name")
public class LoginController {

    AuthenticationService authService;

    public LoginController(AuthenticationService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if (authService.authenticateUser(name, password)) {

            model.put("name", name);

            return "welcome";
        }

        model.put("errorMessage", "Invalid credentials.Please try Again");
        return "login";
    }
}
