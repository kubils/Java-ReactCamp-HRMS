package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CV.CvLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvLanguageDao extends JpaRepository<CvLanguages, Integer> {
    List<CvLanguages> getByResumes_Candidates_Id(int candidateId);
}
