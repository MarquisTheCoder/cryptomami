package com.example.gtaforums.forum;

import com.example.gtaforums.posts.Post;
import com.example.gtaforums.posts.PostJson;
import com.example.gtaforums.posts.PostRepository;
import com.example.gtaforums.users.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired private PostRepository postRepository;
    @Autowired private UserRepository userRepository;

    @GetMapping()
    private String forum(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("allpost", postRepository.findParents());
        return "forum/forum";
    }

    @PostMapping()
    private String post(@ModelAttribute Post post){

        post.setTimestamp( new Timestamp(new Date().getTime()));

        //hard-coding the first user in the database to all post
        //that are sent to the server before the implementation of
        //authentication
        post.setUser(userRepository.findAll().get(0));
        postRepository.save(post);
        return "redirect:/forum";
    }

    @GetMapping(value = "/{id}/post",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private String postReplies(@PathVariable String id) throws JsonProcessingException {

        //gets all the replies of a given post via the post id
        ArrayList<Post> children = postRepository.findChildrenByParent(Long.parseLong(id));

        //holds all PostJson objects for later conversion
        ArrayList<PostJson> childArray = new ArrayList<>();

        //converts the Post Entity into a PostJson object and so it
        //can be mapped and converted correctly by the jackson object
        //mapper
        children.forEach(child ->{
           PostJson post = PostJson.builder()
                   .parentId(Long.parseLong(id))
                   .title(child.getTitle())
                   .content(child.getContent())
                   .id(child.getId())
                   .timestamp(child.getTimestamp())
                   .build();
           childArray.add(post);
        });

        //object mapper turns the current PostJson object into a json object
        //to be sent to the client which is being fetched in our reply.js
        //when the user clicks the 'show replies' button
        return (new ObjectMapper()
                .writeValueAsString(childArray));
    }

    @PostMapping("/{id}/post")
    private String post(@RequestParam String title,
                        @RequestParam String content,
                        @PathVariable String id){

        Date date = new Date();

        //creates a post object and saves the reply post to the database with a hardcoded user
        Post replyPost = Post.builder()
                .parent_post(postRepository.getReferenceById(Long.parseLong(id)))
                .user(userRepository.findAll().get(0))
                .title(title)
                .timestamp(new Timestamp(date.getTime()))
                .content(content)
                .build();

        //save the post to the connecting MySql database via the JPA
        postRepository.save(replyPost);
        return "redirect:/forum";
    }

}
