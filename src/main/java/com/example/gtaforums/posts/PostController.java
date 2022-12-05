package com.example.gtaforums.posts;

import com.example.gtaforums.threads.ThreadRepository;
import com.example.gtaforums.users.User;
import com.example.gtaforums.users.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/post")
public class PostController{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;
    public PostController(PostRepository postRepository,
                          UserRepository userRepository,
                          ThreadRepository threadRepository){
        this.userRepository =  userRepository;
        this.postRepository = postRepository;
        this.threadRepository = threadRepository;
    }
    @GetMapping("/create/{userId}/{threadId}/{content}")
    public String createPost(@PathVariable String userId,
                             @PathVariable String threadId,
                             @PathVariable String content){

        Date date = new Date();

        Post post  = Post.builder()
                .user(userRepository.getReferenceById(Long.parseLong(userId)))
                .content(content)
                .status(1)
                .parentThread(threadRepository.getReferenceById(Long.parseLong(threadId)))
                .timestamp(new Timestamp(date.getTime()))
                .build();

        postRepository.save(post);
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
