package com.example.demo.api.scrapper;


import com.example.demo.api.data.model.JobPost;
import com.example.demo.api.dtos.JobPostDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyScrapper implements ICompanyScrapper {

    @Override
    public List<JobPostDTO> scrapeJobPosts(){
        List<JobPostDTO> jobPostDTOS = new ArrayList<>();
        try{
            Document doc = Jsoup.connect("https://www.ycombinator.com/jobs").get();
            Element ele = doc.getElementsByClass("space-y-2 overflow-hidden").first();
            Elements textDivs = ele.getElementsByClass("flex-1 text-center md:text-left");
            for(Element textDiv : textDivs){
                JobPostDTO jobPost = new JobPostDTO();
                Element companyNameEle = textDiv.getElementsByTag("a").first();
                Element placeEle = textDiv.getElementsByTag("div").get(2);

                jobPost.setCompanyName(
                        companyNameEle.getElementsByTag("span").first().text()
                );
                jobPost.setDepartment(
                        companyNameEle.getElementsByTag("span").get(2).text()
                );

                jobPost.setTitle(
                        textDiv.getElementsByTag("div").get(1)
                                .getElementsByTag("div")
                                .get(0)
                                .text()
                );

                jobPost.setFullTime(
                        placeEle.getElementsByTag("div").get(0)
                                .getElementsByTag("div").get(1)
                                .text().toLowerCase().contains("full")
                );
                jobPost.setPlace(
                        placeEle.getElementsByTag("div").get(0)
                                .getElementsByTag("div").get(2)
                                .text()
                );
                jobPost.setJobRole(
                        placeEle.getElementsByTag("div").get(0)
                                .getElementsByTag("div").get(3)
                                .text()
                );
                jobPostDTOS.add(jobPost);
            }
        }catch (Exception e){
            return Collections.emptyList();
        }

        return jobPostDTOS;

    }
}
