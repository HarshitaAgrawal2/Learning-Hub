package com.example.skillhub.services;

import com.example.skillhub.model.Blog;
import com.example.skillhub.dao.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> getAllBlogs(int page, int size) {
        return blogRepository.findAllProjectedBy(PageRequest.of(page, size));
    }

    public Optional<Blog> getBlogById(String id) {
        return blogRepository.findById(id);
    }

    public Blog likeBlog(String id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
        blog.setLikes(blog.getLikes() + 1);
        return blogRepository.save(blog);
    }
}
