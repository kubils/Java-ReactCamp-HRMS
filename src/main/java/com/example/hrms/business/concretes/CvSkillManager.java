package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CvSkillService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvSkillDao;
import com.example.hrms.entities.concretes.CV.CvSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSkillManager implements CvSkillService {

    private CvSkillDao cvSkillDao;

    @Autowired
    public CvSkillManager(CvSkillDao cvSkillDao) {
        this.cvSkillDao = cvSkillDao;
    }

    @Override
    public Result add(CvSkills cvSkill) {
        this.cvSkillDao.save(cvSkill);
        return new SuccessResult("skill added");
    }

    @Override
    public DataResult<List<CvSkills>> getSkillsByCandidates_Id(int candidateId) {
        return new SuccessDataResult<List<CvSkills>>
                (this.cvSkillDao.getByResumes_Candidates_Id(candidateId), "listed skills");

    }
}
