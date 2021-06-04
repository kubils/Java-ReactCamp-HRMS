package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.concretes.utilities.*;
import com.example.hrms.dataAccess.abstracts.EmployerUserDao;
import com.example.hrms.dataAccess.abstracts.JobPostDao;
import com.example.hrms.entities.concretes.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobPostManager implements JobPostService {

    JobPostDao jobPostDao;
    EmployerUserDao employerUserDao;
   
    @Autowired
    public JobPostManager(JobPostDao jobPostDao, EmployerUserDao employerUserDao) {
        this.jobPostDao = jobPostDao;
        this.employerUserDao = employerUserDao;
    }


    @Override
    public DataResult<List<Jobs>> getAll() {
        return new SuccessDataResult<List<Jobs>>
                (this.jobPostDao.findAll(), "jobs listed");
    }

    @Override
    public Result add(Jobs jobs) {
      this.jobPostDao.save(jobs);
        return new SuccessResult("Jobs added!");
    }
    @Override
    public DataResult<Jobs> setJobDisabled(int id) {
        if(!this.jobPostDao.existsById(id)) {
            return new ErrorDataResult<Jobs>("There is not any employer with this id!!");
        } else {
            Jobs job = this.jobPostDao.getOne(id);
            job.setActive(false);
            return new SuccessDataResult<Jobs>
                    (this.jobPostDao.save(job), "selected job inactivated");
        }
    }

    @Override
    public DataResult<List<Jobs>> getByIsActive(boolean isActive) {
        if (isActive) {
            return new SuccessDataResult<List<Jobs>>
                    (this.jobPostDao.getByActive(isActive), "active data listed");
        } else {
            return new SuccessDataResult<List<Jobs>>
                    (this.jobPostDao.getByActive(isActive), "inactive data listed");
        }

    }

   @Override
   public DataResult<List<Jobs>> findByIs_ActiveTrueOrderByDate_Of_Open() {
        return new SuccessDataResult<Jobs>
                (this.jobPostDao.findByActiveTrueOrderByDateOfOpen(), "active data listed with ordered with date");
    }

    @Override
    public DataResult<List<Jobs>> getByEmployer_Id(int employerId) {

        return new SuccessDataResult<List<Jobs>>
                (this.jobPostDao.getByEmployersId(employerId), "all jobs listed");


    }

    @Override
    public DataResult<List<Jobs>> findByActiveTrueAndEmployers(int employerId) {
            return new SuccessDataResult<List<Jobs>>
                    (this.jobPostDao.findByActiveTrueAndEmployersId(employerId), "all active jobs listed");
    }
}
