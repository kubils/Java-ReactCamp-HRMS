package com.example.hrms.business;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.dataAccess.abstracts.HrmsDao;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//class job is run as service
@Service
public class JobTitleManager implements JobTitleService {

    //Dependency Inj : reach Dao
    private HrmsDao hrmsDao;
    //spring creates instance with
    @Autowired // autowired gives HrmsDao instance : hPD  h = new hPD
    public JobTitleManager(HrmsDao hrmsDao) {
        this.hrmsDao = hrmsDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return this.hrmsDao.findAll();
    }
}
