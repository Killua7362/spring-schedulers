package com.example.demo.api.data;

import com.example.demo.api.data.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByCompany_CompanyIdAndDepartmentNameEqualsIgnoreCase(String companyCompanyId, String departmentName);
}
