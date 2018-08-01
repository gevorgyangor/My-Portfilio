package com.example.portfilio.controller;

import com.example.portfilio.model.User;
import com.example.portfilio.model.UserType;
import com.example.portfilio.repository.UserRepository;
import com.example.portfilio.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }


    @PostMapping("/register")
    public String registerUser(ModelMap map) {
        map.addAttribute("user", new User());
        return "regForm";
    }

    @GetMapping("/login")
    public String login(ModelMap map) {
        map.addAttribute("user", new User());
        return "logForm";
    }

    @PostMapping(value = "/loginUser")
    public String loginUser(@AuthenticationPrincipal UserDetails userDetails) {
        User user = ((CurrentUser) userDetails).getUser();
        if (user.getType() == UserType.USER) {
            return "redirect:/";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin")
    public String admin(ModelMap map) {

        return "admin";

    }
}
