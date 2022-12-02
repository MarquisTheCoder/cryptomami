package com.example.gtaforums.users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController{

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    public UserController(PasswordEncoder passwordEncoder,
                          UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "navigation/register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

}
