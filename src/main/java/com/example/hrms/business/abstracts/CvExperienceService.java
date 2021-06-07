package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvExperiences;

import java.util.List;

public interface CvExperienceService {
    Result add(CvExperiences cvExperience);

    DataResult<List<CvExperiences>> getByDateOfFinish(int candidateId);

}
