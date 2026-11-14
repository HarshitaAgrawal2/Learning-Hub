package com.example.skillhub.dao;


import com.example.skillhub.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BlogRepository extends MongoRepository<Blog, String> {

    // Uses a projection to only fetch ID and Title for the list view (Saves memory/bandwidth)
    @Query(value = "{}", fields = "{ 'blogId' : 1, 'blogTitle' : 1}")
    Page<Blog> findAllProjectedBy(Pageable pageable);
}

