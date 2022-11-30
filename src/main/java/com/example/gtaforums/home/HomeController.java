package com.example.gtaforums.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//this Controller is basically used for the homepage of the website
//it somewhat represents the root of the website
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping()
    private String home(){
        return "home";
    }

    //testing the home controller
    @GetMapping("/home")
    private String homeAlternative(){
        return "redirect:/";
    }

    @GetMapping("/test")
    private @ResponseBody String test(){
        return "This is a test";
    }
}
