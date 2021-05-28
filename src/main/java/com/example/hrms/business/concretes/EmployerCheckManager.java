package com.example.hrms.business.concretes;

import com.example.hrms.dataAccess.abstracts.EmployerUserDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Employers;

import java.util.regex.Pattern;

public class EmployerCheckManager {
    private EmployerUserDao employerUserDao;
    private UserDao userDao;

    public EmployerCheckManager(EmployerUserDao employerUserDao, UserDao userDao) {
        this.employerUserDao = employerUserDao;
        this.userDao = userDao;
    }


    public boolean allFieldsAreFilled(Employers employer) {
        if (employer.getName().isEmpty()
                || employer.getEmail().isEmpty()
                || employer.getPassword().isEmpty()
                || employer.getWebsite().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean findByEmail(Employers employers) {
        return !this.userDao.existsByemail(employers.getEmail());
    }

    private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }


    public String checkAddResult(Employers employers) {
        if (!findByEmail(employers)) {
            return "Email exist";
        } else if (!allFieldsAreFilled(employers)) {
            return "Do not blank any field";
        } else if(!isEmailValid(employers.getEmail())) {
            return "Not valid mail type";
        } else if(!employers.getEmail().endsWith(employers.getWebsite())) {
            return "Web adress must be same with email domain";
        }
        return "";
    }
}
