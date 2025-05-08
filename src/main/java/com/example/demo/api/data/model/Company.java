package com.example.demo.api.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "COMPAINIES")
public class Company extends BaseAuditedModel {

    @Id
    @Column(name = "COMPANY_ID")
    private String companyId;

    @Column(name ="COMPANY_NAME")
    private String companyName;

}
