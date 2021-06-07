package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CvExperienceService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvExperienceDao;
import com.example.hrms.entities.concretes.CV.CvExperiences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvExperienceManager implements CvExperienceService {

    private CvExperienceDao cvExperienceDao;

    @Autowired
    public CvExperienceManager(CvExperienceDao cvExperienceDao) {
        this.cvExperienceDao = cvExperienceDao;
    }


    @Override
    public Result add(CvExperiences cvExperience) {
        this.cvExperienceDao.save(cvExperience);
        return new SuccessResult("experience added");
    }

    @Override
    public DataResult<List<CvExperiences>> getByDateOfFinish(int candidateId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "leaveYear");

        return new SuccessDataResult<List<CvExperiences>>
                (this.cvExperienceDao.getByResumes_Candidates_Id(candidateId, sort), "listed resume");

    }

}
