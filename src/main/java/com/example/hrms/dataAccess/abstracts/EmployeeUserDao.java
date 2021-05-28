package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeUserDao extends JpaRepository<Employees, Integer> {
}
