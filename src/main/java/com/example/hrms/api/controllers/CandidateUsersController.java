package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CandidateUserService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class CandidateUsersController {

    private CandidateUserService candidateUserService;

    @Autowired
    public CandidateUsersController(CandidateUserService candidateUserService) {
        this.candidateUserService = candidateUserService;
    }


    @GetMapping("/getAll/candidates")
    public DataResult<List<Candidates>> getAll() {
        return this.candidateUserService.getAll();
    }

    @PostMapping("/add/candidates")
    public Result add(@RequestBody Candidates candidates) {
        return this.candidateUserService.add(candidates);
    }

}