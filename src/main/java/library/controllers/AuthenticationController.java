package library.controllers;

import jakarta.annotation.Resource;
import library.model.User;
import library.service.impl.AuthenticationService;
import library.session.SessionObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @GetMapping(path = "/login")
    public String login(Model model) {
        model.addAttribute("userModel", new User());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "login";
    }

    @PostMapping(path = "/login")
    public String login(@ModelAttribute User user) {
        this.authenticationService.login(user);
        if (this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        return "redirect:/authentication/login";
    }

    @GetMapping(path = "/register")
    public String register(Model model) {
        model.addAttribute("userModel", new User());
        return "register";
    }

    @PostMapping(path = "/register")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("userModel", new User());
        this.authenticationService.register(user);
        return "registration_succesful";
    }


    @GetMapping(path = "/logout")
    public String logout() {
        this.authenticationService.logout();
        return "redirect:/main";
    }
}
