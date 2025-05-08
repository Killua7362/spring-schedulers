package com.example.demo.api.services;

import com.example.demo.api.builder.JobPostBuilder;
import com.example.demo.api.data.CompanyRepository;
import com.example.demo.api.data.DepartmentRepository;
import com.example.demo.api.data.JobPostRepository;
import com.example.demo.api.data.model.Company;
import com.example.demo.api.data.model.Department;
import com.example.demo.api.data.model.JobPost;
import com.example.demo.api.dtos.JobPostDTO;
import com.example.demo.api.scrapper.CompanyScrapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService implements ICompanyService {

    private final CompanyScrapper companyScrapper;
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final JobPostRepository jobPostRepository;
    private final JobPostBuilder builder;

    @Override
    public void saveFeed(){
        List<JobPostDTO> feeds = companyScrapper.scrapeJobPosts();

        List<JobPost> jobPosts = feeds.stream().map(feed -> {
            Optional<Company> company = companyRepository.findByCompanyNameContainingIgnoreCase(feed.getCompanyName());
            Company existingCompany;
            if(company.isEmpty()){
                Company newCompany = new Company();
                newCompany.setCompanyName(feed.getCompanyName());
                existingCompany = companyRepository.save(newCompany);
            } else{
                existingCompany = company.get();
            }

            Optional<Department> department = departmentRepository.findByCompany_CompanyIdAndDepartmentNameEqualsIgnoreCase(existingCompany.getCompanyId(),feed.getCompanyName());
            Department existingDepartment;

            if(department.isEmpty()){
                Department newDepartment = new Department();
                newDepartment.setCompany(existingCompany);
                existingDepartment = departmentRepository.save(newDepartment);
            }else{
                existingDepartment = department.get();
            }

            return builder.populateJobPost(existingCompany, existingDepartment, feed);
        }).toList();

        jobPostRepository.saveAll(jobPosts);
    }
}
