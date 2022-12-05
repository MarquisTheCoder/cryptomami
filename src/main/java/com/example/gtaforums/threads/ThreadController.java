package com.example.gtaforums.threads;

import com.example.gtaforums.posts.Post;
import com.example.gtaforums.posts.PostJson;
import com.example.gtaforums.posts.PostRepository;
import com.example.gtaforums.users.User;
import com.example.gtaforums.users.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/threads")
public class ThreadController {

    private final ThreadRepository threadRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public ThreadController(ThreadRepository threadRepository,
                            PostRepository postRepository,
                            UserRepository userRepository){
        this.threadRepository = threadRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String threads(Model model, @PathVariable String id) throws JsonProcessingException {
        Thread thread = threadRepository.findById(Long.parseLong(id));
        List<Post> childPosts =  postRepository.findPostsByParentThread(thread);
        List<PostJson> postJsons = new ArrayList<>();

        for(Post post : childPosts){
            PostJson postJson = PostJson.builder()
                    .content(post.getContent())
                    .id(post.getId())
                    .timestamp(post.getTimestamp())
                    .profileImg(post.getUser().getProfileImg())
                    .username(post.getUser().getUsername())
                    .build();
            postJsons.add(postJson);
        }
        return (new ObjectMapper().writeValueAsString(postJsons));
    }

    @GetMapping("/create/{title}")
    @ResponseBody
    public String createPost(@PathVariable String title){
        Date date = new Date();
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Thread thread = Thread.builder()
                .timestamp(new Timestamp(date.getTime()))
                .subject(title)
                .user(userRepository.getReferenceById(loggedInUser.getId()))
                .build();
        threadRepository.save(thread);
        return "";
    }
}
