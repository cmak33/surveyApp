package com.example.surveyapplication.controllers.home;

import com.example.surveyapplication.models.dtos.SurveyDTO;
import com.example.surveyapplication.models.entities.User;
import com.example.surveyapplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("")
    public String home(Model model){
        User user = userService.receiveCurrentUser();
        model.addAttribute("user",user);
        return "home/home";
    }

    @GetMapping("/completedSurveys")
    public String completedSurveys(Model model){
        List<SurveyDTO> completedSurveys = userService.receiveCurrentUser().getSurveys().stream().map(SurveyDTO::new).toList();
        model.addAttribute("surveys",completedSurveys);
        return "home/completedSurveysList";
    }
}
