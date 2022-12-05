package com.example.gtaforums.users;

import com.example.gtaforums.posts.Post;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false) private Long id;
    @Column(unique = true, nullable = false) private String username;
    @Column (nullable = false) private String password;
    @Column private String cryptoAddress;
    @Column private String profileImg;

}
