package com.example.gtaforums.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController{

    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @GetMapping("/create")
    public String home(){
        return "redirect:/forum";
    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable String id){
//        Post currentPost = postRepository.getReferenceById(Long.parseLong(id));
        postRepository.deleteById(Long.parseLong(id));
        return "redirect:/forum";
    }
}
