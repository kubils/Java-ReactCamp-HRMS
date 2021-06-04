package com.example.hrms.business.abstracts;


import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.Candidates;

import java.util.List;

public interface CandidateUserService {
    Result add(Candidates candidates);
    DataResult<List<Candidates>> getAll();
    DataResult<List<Candidates>> getById(int id);
}
