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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(ModelMap map) {
        return "index";
    }

    @GetMapping(value = "/addUser")
    public String register(ModelMap map) {
        map.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap map) {
        map.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(@AuthenticationPrincipal UserDetails userDetails) {
        User user = ((CurrentUser) userDetails).getUser();
        if (user.getType() == UserType.USER) {
            return "redirect:/";
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(ModelMap map) {

        return "admin";

    }
}
