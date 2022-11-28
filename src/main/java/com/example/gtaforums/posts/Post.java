package com.example.gtaforums.posts;

import com.example.gtaforums.users.User;
import javax.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column private String title;
    @Column(length = 1000) private String content;
    @Column private Timestamp timestamp;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn (name = "user_id")
    private User user;
    @OneToOne Post parent_post;
}
