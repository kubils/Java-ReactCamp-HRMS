package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.Jobs;

import java.util.Date;
import java.util.List;

public interface JobPostService {

    DataResult<List<Jobs>> getAll();
    Result add(Jobs jobs);
    DataResult<List<Jobs>>  getByIsActive(boolean isActive);
    DataResult<List<Jobs>> findByIs_ActiveTrueOrderByDate_Of_Open();
    DataResult<List<Jobs>>  getByEmployer_Id(int employerId);
    DataResult<List<Jobs>>  findByActiveTrueAndEmployers(int employerId);

}
