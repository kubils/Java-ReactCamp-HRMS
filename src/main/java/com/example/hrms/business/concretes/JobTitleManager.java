package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.core.concretes.utilities.*;
import com.example.hrms.dataAccess.abstracts.JobPositonDao;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//class job is run as service
@Service
public class JobTitleManager implements JobTitleService {

    //Dependency Inj : reach Dao
    private JobPositonDao jobPositonDao;
    //spring creates instance with
    @Autowired // autowired gives HrmsDao instance : hPD  h = new hPD
    public JobTitleManager(JobPositonDao jobPositonDao) {
        this.jobPositonDao = jobPositonDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult(this.jobPositonDao.findAll(),"job position listed");
    }

    @Override
    public Result add(JobTitle jobTitle) {
        if (this.jobPositonDao.existsBytitle(jobTitle.getTitle())) {
            return new ErrorResult("Job title exist");
        } else {
            this.jobPositonDao.save(jobTitle);
            return new SuccessResult("Job title added");
        }
    }
}
