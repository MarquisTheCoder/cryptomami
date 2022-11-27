package com.example.gtaforums.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @GetMapping()
    private String forum(){
        return "navigation/forum-logged-out";
    }
    @GetMapping("/threads/{id}")
    private String forumThread(@PathVariable int id){
        return "";
    }
}
