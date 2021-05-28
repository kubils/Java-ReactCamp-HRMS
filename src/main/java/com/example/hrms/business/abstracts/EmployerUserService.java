package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.Employers;

import java.util.List;

public interface EmployerUserService {
    Result add(Employers employers);
    DataResult<List<Employers>> getAll();
}
