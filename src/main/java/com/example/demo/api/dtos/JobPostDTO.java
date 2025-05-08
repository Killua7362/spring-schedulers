package com.example.demo.api.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostDTO {
    private String companyName;

    private String department;

    private String title;

    private Boolean fullTime;

    private String place;

    private String jobRole;
}
