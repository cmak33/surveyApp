package com.example.surveyapplication.controllers;

import com.example.surveyapplication.models.User;
import com.example.surveyapplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final UserService userService;

    @GetMapping("")
    public String home(Model model){
        User user = userService.receiveCurrentUser();
        model.addAttribute("user",user);
        return "home/home";
    }
}
