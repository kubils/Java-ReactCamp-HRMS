package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateCheckService;
import com.example.hrms.core.adapter.abstracts.MernisAdapterService;
import com.example.hrms.dataAccess.abstracts.CandidateUserDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CandidateCheckManager implements CandidateCheckService {

    private CandidateUserDao candidateUserDao;
    private UserDao userDao;
    private MernisAdapterService mernisAdapterService;

    @Autowired
    public CandidateCheckManager(CandidateUserDao candidateUserDao, UserDao userDao, MernisAdapterService mernisAdapterService) {
        this.candidateUserDao = candidateUserDao;
        this.userDao = userDao;
        this.mernisAdapterService = mernisAdapterService;
    }


    @Override
    public boolean allFieldsAreFilled(Candidates candidates) {
        if (candidates.getName().isEmpty()
            || candidates.getLastName().isEmpty()
            || candidates.getIdentityNumber().isEmpty()
            || candidates.getEmail().isEmpty()
            || candidates.getPassword().isEmpty()
            || candidates.getBirthDate() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean findAllByEmail(Candidates candidates) {
        return !this.userDao.existsByemail(candidates.getEmail());
    }

    @Override
    public boolean checkMernis(Candidates candidates) {
        if (this.mernisAdapterService.checkIfRealPerson(candidates)) {
            return true;
        }
        return false;
    }
    private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }

    @Override
    public String checkAddResult(Candidates candidates) {
        if(!checkMernis(candidates)) {
            return "Wrong identity number";
        } else if(!findAllByEmail(candidates)) {
            return "Email exist";
        } else if(!allFieldsAreFilled(candidates)) {
            return "Do not blank any field";
        } else if(candidateUserDao.existsByidentityNumber(candidates.getIdentityNumber())){
            return "Identity number exist";
        } else if(!isEmailValid(candidates.getEmail())) {
            return "Not valid mail type";
        }
        return "";
    }
}
