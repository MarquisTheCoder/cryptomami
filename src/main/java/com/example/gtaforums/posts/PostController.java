package com.example.gtaforums.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController{

    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @GetMapping("/create")
    public String home(){
        return "home";
    }
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable String id){
        Post currentPost = postRepository.getReferenceById(Long.parseLong(id));
        postRepository.delete(currentPost);
        return "redirect:/forum";
    }
}
