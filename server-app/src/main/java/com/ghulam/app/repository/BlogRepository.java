package com.ghulam.app.repository;

import com.ghulam.app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByTitleContainingIgnoreCase(String title);
}
