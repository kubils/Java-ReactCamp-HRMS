package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvExperiences;
import com.example.hrms.entities.concretes.CV.CvLanguages;

import java.util.List;

public interface CvLanguageService {
    Result add(CvLanguages cvLanguage);

    DataResult<List<CvLanguages>> getByCandidates_Id(int candidateId);

}
