package com.example.gtaforums.threads;

import com.example.gtaforums.posts.Post;
import com.example.gtaforums.posts.PostJson;
import com.example.gtaforums.posts.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/threads")
public class ThreadController {
    private ThreadRepository threadRepository;
    private PostRepository postRepository;
    public ThreadController(ThreadRepository threadRepository, PostRepository postRepository){
        this.threadRepository = threadRepository;
        this.postRepository = postRepository;
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
}
