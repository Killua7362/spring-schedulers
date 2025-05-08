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
@Table(name = "DEPARTMENT")
public class Department extends BaseAuditedModel{

    @Id
    @Column(name = "DEPARTMENT_ID")
    private String departmentId;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID",referencedColumnName = "COMPANY_ID")
    private Company company;

    @Column(name ="DEPARTMENT")
    private String departmentName;

}
