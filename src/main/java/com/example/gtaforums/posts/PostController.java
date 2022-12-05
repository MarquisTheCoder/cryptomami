package com.example.gtaforums.posts;

import com.example.gtaforums.users.User;
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
    @GetMapping("/edit/{id}/{content}")
    public String editPost(@PathVariable String id,
                           @PathVariable String content){
        Post currentPost = postRepository.getReferenceById(Long.parseLong(id));
        currentPost.setContent(content);
        postRepository.save(currentPost);
        return "redirect:/forum";


    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable String id){
//        Post currentPost = postRepository.getReferenceById(Long.parseLong(id));
        postRepository.deleteById(Long.parseLong(id));
        return "redirect:/forum";
    }
}
