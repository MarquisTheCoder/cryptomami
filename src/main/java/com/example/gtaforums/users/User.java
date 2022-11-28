package com.example.gtaforums.users;

import com.example.gtaforums.posts.Post;
import lombok.*;
import org.hibernate.Hibernate;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> post;
}
