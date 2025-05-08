package com.example.demo.api.scrapper;

import com.example.demo.api.dtos.JobPostDTO;

import java.util.List;

public interface ICompanyScrapper {
    List<JobPostDTO> scrapeJobPosts();
}
