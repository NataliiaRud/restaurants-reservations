package ua.study.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Login form controller
 */

@RequestMapping("/login")
@Controller
public class LoginController {
    @GetMapping
    public String login() {
        return "login";
    }
}
