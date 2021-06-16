package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;

import com.example.hrms.entities.concretes.WorkType;

import java.util.List;

public interface WorkTypeService {
    DataResult<List<WorkType>> getAll();
    Result add(WorkType workType);
}
