package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Resumes;
import com.example.hrms.entities.dtos.ResumeWithCandidateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resumes, Integer> {


   /* @Query("SELECT new com.example.hrms.entities.dtos.ResumeDto(r.id, r.resumeName, c.name, c.id, cSch.university)"
            + "FROM Resumes r INNER JOIN r.candidates c"
            + "INNER JOIN r.candidateExperiences cExp"
            + "Inner JOIN r.candidateLanguages cLng"
            + "Inner join r.candidateLinks cLnk"
            + "inner join r.candidateSchools cSch"
            + "inner join r.candidatesImage cImg"
            + "inner join r.candidateSkills cSkl"
            + "inner join r.candidateSummaries cSmr")
    List<ResumeDto> getAlgl();*/

    //one to many cantidate to resume
    //gets all starts with from
    //@Query("From")

    //or specified column select ... from
    //select
    @Query("SELECT new com.example.hrms.entities.dtos.ResumeWithCandidateDto(r.id, r.resumeName, c.name, c.id)"
            + "FROM Resumes r INNER JOIN r.candidates c")
    List<ResumeWithCandidateDto> getResumeWithCandideDetails();

    //"SELECT new com.example.hrms.entities.dtos.ResumeWithCandidateDto(r.id, r.resumeName, c.name, c.id)"
    //            +
    @Query("FROM Resumes r INNER JOIN r.candidates c where c.id =:candidateId" )
    List<Resumes> getByResumes_Candidates_Id(int candidateId);



}
