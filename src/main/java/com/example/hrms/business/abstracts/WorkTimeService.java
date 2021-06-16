package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.WorkTime;

import java.util.List;

public interface WorkTimeService {
    DataResult<List<WorkTime>> getAll();
    Result add(WorkTime workTime);
}
