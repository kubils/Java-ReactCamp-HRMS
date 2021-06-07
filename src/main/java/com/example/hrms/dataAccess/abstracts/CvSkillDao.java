package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CV.CvSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvSkillDao extends JpaRepository<CvSkills, Integer> {
    List<CvSkills> getByResumes_Candidates_Id(int candidateId);

}
