package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

//extends interface JpaRepository<class, id>
public interface JobPositonDao extends JpaRepository<JobTitle, Integer> {
    boolean existsBytitle(String title);
}
