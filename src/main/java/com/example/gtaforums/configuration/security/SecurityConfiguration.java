package com.example.gtaforums.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration{
    //tells the configuration file to add this to the spring
    //apps configuration
    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/forum").authenticated()
                .antMatchers("/","/home", "/register").permitAll()
                    .and().formLogin().loginPage("/login").defaultSuccessUrl("/forum")
                    .and().logout()
                    .and().httpBasic();
        http.formLogin();
        http.httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
