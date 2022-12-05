package com.example.gtaforums.posts;

import com.example.gtaforums.threads.Thread;
import com.example.gtaforums.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value="Select p FROM Post p WHERE p.parentPost IS null ")
    List<Post> findParents();
    List<Post> findPostsByParentThread(Thread thread);
    @Query(value = "Select p from Post p Where p.parentPost.id = :parentId")
    ArrayList<Post> findChildrenByParent(@Param("parentId") Long parentId);

    ArrayList<Post> findPostsByUser(User user);
}
