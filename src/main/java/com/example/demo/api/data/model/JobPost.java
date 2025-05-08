package com.example.demo.api.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "JOB_POST")
public class JobPost extends BaseAuditedModel{

    @Id
    @Column(name = "JOB_ID")
    private String jobId;

    @ManyToOne
    @JoinColumn(name="DEPARTMENT_ID",referencedColumnName = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne
    @JoinColumn(name="COMPANY_ID",referencedColumnName = "COMPANY_ID")
    private Company company;

    @Column(name ="TITLE")
    private String title;

    @Column(name ="FULL_TIME")
    private Boolean fullTime;

    @Column(name ="LOCATION")
    private String location;

    @Column(name ="ROLE")
    private String role;

}
