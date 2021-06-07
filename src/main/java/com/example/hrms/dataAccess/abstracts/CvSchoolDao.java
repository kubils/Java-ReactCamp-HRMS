package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CV.CvSchools;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvSchoolDao extends JpaRepository<CvSchools, Integer> {
    List<CvSchools> getByResumes_Candidates_Id(int candidateId, Sort sort);

}
