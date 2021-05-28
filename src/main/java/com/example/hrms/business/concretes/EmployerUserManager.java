package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployeeUserService;
import com.example.hrms.business.abstracts.EmployerUserService;
import com.example.hrms.core.adapter.abstracts.EmailVerficationService;
import com.example.hrms.core.concretes.utilities.*;
import com.example.hrms.dataAccess.abstracts.EmployerUserDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.Employers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerUserManager implements EmployerUserService {

    private EmployerUserDao employerUserDao;
    private UserDao userDao;
    private EmailVerficationService emailVerficationService;
    private EmployeeUserService employeeUserService;

    public EmployerUserManager(EmployerUserDao employerUserDao, UserDao userDao,
                               EmailVerficationService emailVerficationService, EmployeeUserService employeeUserService) {
        this.employerUserDao = employerUserDao;
        this.userDao = userDao;
        this.emailVerficationService = emailVerficationService;
        this.employeeUserService = employeeUserService;
    }

    @Override
    public Result add(Employers employers) {
            EmployerCheckManager employerCheckManager = new EmployerCheckManager(this.employerUserDao, this.userDao);

            if (!employerCheckManager.checkAddResult(employers).equals("")) {
                return new ErrorResult(employerCheckManager.checkAddResult(employers));
            }
            //control email verification with : activation email and employee confirms
            else if(!emailVerficationService.isEmailActivated(employers.getEmail())
                    && !employeeUserService.verifyEmployerLogs(employers)) {
                return new ErrorResult(employers.getEmail() + " not verified");
            } else {
                this.employerUserDao.save(employers);
                return new SuccessResult(employers.getEmail() + " employers added");
            }
    }

    @Override
    public DataResult<List<Employers>> getAll() {
        return new SuccessDataResult<Employers>(employerUserDao.findAll(), "Listed all employer");
    }
}
