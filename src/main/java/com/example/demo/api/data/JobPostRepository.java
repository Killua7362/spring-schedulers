package com.example.demo.api.data;

import com.example.demo.api.data.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    List<JobPost> findByCreatedDateAfter(LocalDateTime createdDateAfter);
}
