package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateUserDao extends JpaRepository<Candidates, Integer> {
    boolean existsByidentityNumber(String identityNumber);
    Candidates getById(int id);

}
