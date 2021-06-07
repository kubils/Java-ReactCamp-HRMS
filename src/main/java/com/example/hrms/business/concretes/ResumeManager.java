package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvExperienceDao;
import com.example.hrms.dataAccess.abstracts.ResumeDao;
import com.example.hrms.entities.concretes.Resumes;
import com.example.hrms.entities.dtos.ResumeWithCandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private CvExperienceDao cvExperienceDao;


    @Autowired
    public ResumeManager(ResumeDao resumeDao, CvExperienceDao cvExperienceDao) {
        this.resumeDao = resumeDao;
        this.cvExperienceDao = cvExperienceDao;
    }

    @Override
    public Result add(Resumes resume) {
        this.resumeDao.save(resume);
        return new SuccessResult("Resume added!");
    }

    @Override
    public DataResult<List<Resumes>> getAll() {
        return new SuccessDataResult<Resumes>(this.resumeDao.findAll(), "resumes listed");
    }

    @Override
    public DataResult<List<Resumes>> getByCandidates_Id(int candidatesId) {
        return new SuccessDataResult<Resumes>(this.resumeDao.getByResumes_Candidates_Id(candidatesId), "resume listed");
    }

    @Override
    public DataResult<List<ResumeWithCandidateDto>> getResumeWithCandideDetails() {
        return new SuccessDataResult<Resumes>(this.resumeDao.getResumeWithCandideDetails(), "resume listed");
    }

}
