package com.example.gtaforums.home;

import com.example.gtaforums.posts.Post;
import com.example.gtaforums.posts.PostRepository;
import com.example.gtaforums.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/forum")
public class ForumController {

    private PostRepository postRepository;

    public ForumController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @GetMapping()
    private String forum(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("allpost", postRepository.findAll());
        return "navigation/forum-logged-out";
    }

    @PostMapping()
    private String post(@ModelAttribute Post post){

        User user = User.builder()
                .username("josh123")
                .password("josh123")
                .build();

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        post.setTimestamp(timestamp);
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/forum";
    }

}
