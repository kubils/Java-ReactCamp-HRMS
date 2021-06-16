package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.WorkTypeService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.SuccessResult;
import com.example.hrms.dataAccess.abstracts.WorkTypeDao;
import com.example.hrms.entities.concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeManager implements WorkTypeService {
    private WorkTypeDao workTypeDao;

    @Autowired
    public WorkTypeManager(WorkTypeDao workTypeDao) {
        this.workTypeDao = workTypeDao;
    }

    @Override
    public DataResult<List<WorkType>> getAll() {
        return new SuccessDataResult<WorkType>(this.workTypeDao.findAll(),"work type listed");
    }

    @Override
    public Result add(WorkType workType) {
        this.workTypeDao.save(workType);
        return new SuccessResult("work type added");    }
}

