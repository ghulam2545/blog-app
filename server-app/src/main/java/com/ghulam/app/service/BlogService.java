package com.ghulam.app.service;

import com.ghulam.app.dtos.BlogRequest;
import com.ghulam.app.model.Blog;
import com.ghulam.app.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> all() {
        return blogRepository.findAll();
    }

    public Blog read(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public void save(BlogRequest dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.title());
        blog.setBrief(dto.brief());
        blog.setContent(dto.content());
        blog.setImage(dto.image());
        blog.setAuthor(dto.author());
        blog.setCategory(dto.category());
        blog.setCreatedAt(LocalDate.now());
        blog.setLikes(0);

        blogRepository.save(blog);
    }
}
