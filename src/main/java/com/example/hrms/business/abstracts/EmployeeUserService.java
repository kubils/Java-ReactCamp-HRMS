package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.Employees;
import com.example.hrms.entities.concretes.Employers;

import java.util.List;

public interface EmployeeUserService {
    List<Employees> getAll();
    boolean verifyEmployerLogs(Employers employers);
}
