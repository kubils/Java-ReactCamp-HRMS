package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateCheckService;
import com.example.hrms.business.abstracts.CandidateUserService;
import com.example.hrms.core.adapter.abstracts.EmailVerficationService;
import com.example.hrms.core.concretes.utilities.*;
import com.example.hrms.dataAccess.abstracts.CandidateUserDao;
import com.example.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateUserManager implements CandidateUserService {

    private CandidateUserDao candidateUserDao;
    private CandidateCheckService candidateCheckService;
    private EmailVerficationService emailVerficationService;

    @Autowired
    public CandidateUserManager(CandidateUserDao candidateUserDao, CandidateCheckService candidateCheckService,
                                EmailVerficationService emailVerficationService) {
        this.candidateUserDao = candidateUserDao;
        this.candidateCheckService = candidateCheckService;
        this.emailVerficationService = emailVerficationService;
    }


    @Override
    public Result add(Candidates candidates) {
        if (!this.candidateCheckService.checkAddResult(candidates).equals("")) {
            return new ErrorResult(this.candidateCheckService.checkAddResult(candidates));
        } else if(!this.emailVerficationService.isEmailActivated(candidates.getEmail())) {
            return new ErrorResult(candidates.getEmail() + "  not verified yet");
        } else {
            this.candidateUserDao.save(candidates);
            return new SuccessResult(candidates.getEmail() + "  verified, candidate added");
        }
    }

    @Override
    public DataResult<List<Candidates>> getAll() {
        return new SuccessDataResult<Candidates>(this.candidateUserDao.findAll(), "Job seeker listed");
    }
}
