package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.Candidates;

public interface CandidateCheckService {
    boolean allFieldsAreFilled(Candidates candidates);
    boolean findAllByEmail(Candidates candidates);
    boolean checkMernis(Candidates candidates);
    String checkAddResult(Candidates candidates);
}
