package com.example.gtaforums.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthenticationController {
    @GetMapping()
    public String defaultLoginPage(){
        return("homepage/navigation/login");
    }
}
