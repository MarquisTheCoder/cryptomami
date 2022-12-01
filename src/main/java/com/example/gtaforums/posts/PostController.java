package com.example.gtaforums.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController{
    @GetMapping("/create")
    public String home(){
        return "home";
    }
}
