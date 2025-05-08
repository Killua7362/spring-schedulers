package com.example.demo.api;

import com.example.demo.api.scrapper.CompanyScrapper;
import com.example.demo.api.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Schedulers {

    private final CompanyService companyService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void saveJobPostFeed(){
        companyService.saveFeed();
    }

}
