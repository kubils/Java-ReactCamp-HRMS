package com.example.hrms.core.adapter.abstracts;

import com.example.hrms.entities.concretes.Candidates;

public interface MernisAdapterService {
    public boolean checkIfRealPerson(Candidates candidates);
    public boolean checkWithMernisRealPerson(Candidates candidates) throws Exception;
}
