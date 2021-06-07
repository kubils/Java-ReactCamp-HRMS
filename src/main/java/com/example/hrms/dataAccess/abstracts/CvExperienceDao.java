package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CV.CvExperiences;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvExperienceDao extends JpaRepository<CvExperiences, Integer> {
    List<CvExperiences> getByResumes_Candidates_Id(int candidateId, Sort sort);
}
