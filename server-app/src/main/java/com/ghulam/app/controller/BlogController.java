package com.ghulam.app.controller;

import com.ghulam.app.dtos.BlogRequest;
import com.ghulam.app.model.Blog;
import com.ghulam.app.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint.base-url}/blogs")
@CrossOrigin("*")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<?> all() {
        List<Blog> blogs = blogService.all();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Blog blog = blogService.read(id);
        return ResponseEntity.ok(blog);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BlogRequest dto) {
        blogService.save(dto);
        return ResponseEntity.ok("Blog saved successfully");
    }
}
