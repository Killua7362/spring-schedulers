package com.example.demo.api;

import com.example.demo.api.data.JobPostRepository;
import com.example.demo.api.data.model.JobPost;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class Controllers {

    private final JobPostRepository jobPostRepository;

    @ResponseBody
    @RequestMapping(value = "/posts/new")
    public String getNewPosts(){
        List<JobPost> jobPosts = jobPostRepository.findByCreatedDateAfter(LocalDateTime.now().minusDays(1));
        return jobPosts.stream().map(JobPost::getTitle).collect(Collectors.joining("<br>"));
    }
}
