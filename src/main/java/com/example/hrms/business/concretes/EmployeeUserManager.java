package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployeeUserService;
import com.example.hrms.core.concretes.utilities.ErrorResult;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.EmployeeUserDao;
import com.example.hrms.entities.concretes.Employees;
import com.example.hrms.entities.concretes.Employers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeUserManager implements EmployeeUserService {

    private EmployeeUserDao employeeUserDao;

    public EmployeeUserManager(EmployeeUserDao employeeUserDao) {

        this.employeeUserDao = employeeUserDao;
    }

    @Override
    public List<Employees> getAll() {
        return this.employeeUserDao.findAll();
    }

    @Override
    public boolean verifyEmployerLogs(Employers employers) {
        return true;
    }
}
