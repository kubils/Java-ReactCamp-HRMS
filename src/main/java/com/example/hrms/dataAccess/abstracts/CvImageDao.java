package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CV.CvImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvImageDao extends JpaRepository<CvImages, Integer> {
    List<CvImages> getByCandidatesId(int candidateId);

}
