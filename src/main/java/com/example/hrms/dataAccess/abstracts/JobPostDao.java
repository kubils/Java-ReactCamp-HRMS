package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostDao extends JpaRepository<Jobs, Integer> {
    List<Jobs>  getByActive(boolean isActive);
    List<Jobs>  getByEmployersId(int employerId);
    List<Jobs> findByActiveTrueAndEmployersId(int employerId);
    List<Jobs> findByActiveTrueOrderByDateOfOpen();

    /*@Query("From Jobs where active=:isActive and employers.id=:employerId")
    List<Jobs>  getByIs_ActiveAndEmployersId(boolean isActive, int employerId);*/
}
