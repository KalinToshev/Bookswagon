package com.softuni.bookswagon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/login")
public class LoginController {
    @GetMapping
    public String getLoginPage() {
        return "login";
    }
}
