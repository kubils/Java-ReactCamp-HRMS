package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvSchools;
import com.example.hrms.entities.concretes.CV.CvSkills;

import java.util.List;

public interface CvSkillService {
    Result add(CvSkills cvSkill);

    DataResult<List<CvSkills>> getSkillsByCandidates_Id(int candidateId);
}
