package com.example.gtaforums.threads;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/threads")
public class ThreadController {
    private ThreadRepository threadRepository;
    public ThreadController(ThreadRepository threadRepository){
        this.threadRepository = threadRepository;
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String threads(Model model, @PathVariable String id){

        return "forum/forum";
    }
}
