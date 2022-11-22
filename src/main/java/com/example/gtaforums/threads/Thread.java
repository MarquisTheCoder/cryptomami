package com.example.gtaforums.threads;

import com.example.gtaforums.users.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Thread{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column private String subject;
    @Column private Date timestamp;
    @OneToOne User user;
}
