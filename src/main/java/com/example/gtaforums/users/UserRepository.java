package com.example.gtaforums.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByUsername(String username);
}
