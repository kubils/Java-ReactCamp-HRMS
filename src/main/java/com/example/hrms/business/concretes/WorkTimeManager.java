package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.WorkTimeService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.SuccessResult;
import com.example.hrms.dataAccess.abstracts.WorkTimeDao;
import com.example.hrms.entities.concretes.City;
import com.example.hrms.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeManager implements WorkTimeService {

    private WorkTimeDao workTimeDao;

    @Autowired
    public WorkTimeManager(WorkTimeDao workTimeDao) {
        this.workTimeDao = workTimeDao;
    }

    @Override
    public DataResult<List<WorkTime>> getAll() {
        return new SuccessDataResult<WorkTime>(this.workTimeDao.findAll(),"work time listed");
    }

    @Override
    public Result add(WorkTime workTime) {
        this.workTimeDao.save(workTime);
        return new SuccessResult("work time added");    }
}
