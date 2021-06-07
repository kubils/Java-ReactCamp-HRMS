package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CvSchoolService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvSchoolDao;
import com.example.hrms.entities.concretes.CV.CvSchools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSchoolManager implements CvSchoolService {

    private CvSchoolDao cvSchoolDao;

    @Autowired
    public CvSchoolManager(CvSchoolDao cvSchoolDao) {
        this.cvSchoolDao = cvSchoolDao;
    }

    @Override
    public Result add(CvSchools cvSchool) {
        this.cvSchoolDao.save(cvSchool);
        return new SuccessResult("school added");
    }

    @Override
    public DataResult<List<CvSchools>> getByDateOfFinish(int candidateId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "graduateYear");

        return new SuccessDataResult<List<CvSchools>>
                (this.cvSchoolDao.getByResumes_Candidates_Id(candidateId, sort), "sorted graduate year");

    }
}
