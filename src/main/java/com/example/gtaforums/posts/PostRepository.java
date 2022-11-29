package com.example.gtaforums.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostsByTitle(String title);
    @Query(value="Select p FROM Post p WHERE p.parent_post IS null ")
    List<Post> findParents();
    @Query(value = "Select p from Post p Where p.parent_post.id = :parentId")
    ArrayList<Post> findChildrenByParent(@Param("parentId") Long parentId);
}
