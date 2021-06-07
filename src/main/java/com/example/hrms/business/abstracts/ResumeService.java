package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.Resumes;
import com.example.hrms.entities.dtos.ResumeWithCandidateDto;

import java.util.List;

public interface ResumeService {
    Result add(Resumes resumes);
    DataResult<List<Resumes>> getAll();
    DataResult<List<Resumes>>  getByCandidates_Id(int candidatesId);

    DataResult<List<ResumeWithCandidateDto>> getResumeWithCandideDetails();
}
