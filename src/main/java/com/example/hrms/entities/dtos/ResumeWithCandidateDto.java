package com.example.hrms.entities.dtos;

import com.example.hrms.entities.concretes.CV.CvLanguages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWithCandidateDto {

    private int id;
    private String resumeName;
    private String candidateName;
    private  int candidateId;

}
