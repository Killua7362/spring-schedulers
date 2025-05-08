package com.example.demo.api.builder;


import com.example.demo.api.data.model.Company;
import com.example.demo.api.data.model.Department;
import com.example.demo.api.data.model.JobPost;
import com.example.demo.api.dtos.JobPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobPostBuilder {
    public JobPost populateJobPost(Company existingCompany, Department existingDepartment, JobPostDTO jobPostDTO) {
        JobPost jobPost = new JobPost();
        jobPost.setCompany(existingCompany);
        jobPost.setDepartment(existingDepartment);
        jobPost.setRole(jobPostDTO.getJobRole());
        jobPost.setFullTime(jobPostDTO.getFullTime());
        jobPost.setTitle(jobPostDTO.getTitle());
        return jobPost;
    }
}
