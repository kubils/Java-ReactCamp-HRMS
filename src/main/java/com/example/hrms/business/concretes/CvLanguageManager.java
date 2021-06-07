package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CvLanguageService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvLanguageDao;
import com.example.hrms.entities.concretes.CV.CvLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvLanguageManager implements CvLanguageService {

    private CvLanguageDao cvLanguageDao;

    @Autowired
    public CvLanguageManager(CvLanguageDao cvLanguageDao) {
        this.cvLanguageDao = cvLanguageDao;
    }


    @Override
    public Result add(CvLanguages cvLanguage) {
        this.cvLanguageDao.save(cvLanguage);
        return new SuccessResult("language added");
    }

    @Override
    public DataResult<List<CvLanguages>> getByCandidates_Id(int candidateId) {
        return new SuccessDataResult<List<CvLanguages>>
                (this.cvLanguageDao.getByResumes_Candidates_Id(candidateId), "listed schools");

    }
}
