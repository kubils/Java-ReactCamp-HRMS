package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvSchools;

import java.util.List;

public interface CvSchoolService {
    Result add(CvSchools cvSchool);

    DataResult<List<CvSchools>> getByDateOfFinish(int candidateId);
}
