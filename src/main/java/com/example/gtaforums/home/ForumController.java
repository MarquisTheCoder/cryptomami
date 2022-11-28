package com.example.gtaforums.home;

import com.example.gtaforums.posts.Post;
import com.example.gtaforums.posts.PostRepository;
import com.example.gtaforums.users.User;
import com.example.gtaforums.users.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/forum")
public class ForumController {

    private PostRepository postRepository;
    private UserRepository userRepository;
    public ForumController(PostRepository postRepository,
                           UserRepository userRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping()
    private String forum(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("allpost", postRepository.findParents());
        return "navigation/forum-logged-out";
    }

    @PostMapping()
    private String post(@ModelAttribute Post post){
        User user = userRepository.findAll().get(0);
        Date date = new Date();
        post.setTimestamp( new Timestamp(date.getTime()));
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/forum";
    }

}
