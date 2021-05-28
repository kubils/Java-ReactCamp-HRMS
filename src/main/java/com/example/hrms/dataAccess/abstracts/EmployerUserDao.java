package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerUserDao extends JpaRepository<Employers, Integer> {
}
