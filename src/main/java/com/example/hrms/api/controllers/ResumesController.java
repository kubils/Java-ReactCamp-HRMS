package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.Resumes;
import com.example.hrms.entities.dtos.ResumeWithCandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Resumes resumes) {
        return this.resumeService.add(resumes);
    }


    @GetMapping("/getByCandidates_Id")
    public DataResult<List<Resumes>> getByCandidates_Id(@RequestParam  int candidatesId) {
        return this.resumeService.getByCandidates_Id(candidatesId);
    }

    @GetMapping("/getResumeWithCandideDetails")
    public DataResult<List<ResumeWithCandidateDto>> getResumeWithCandideDetails() {
        return this.resumeService.getResumeWithCandideDetails();
    }

    @GetMapping("/getAll")
    public DataResult<List<Resumes>> getAll() {
        return this.resumeService.getAll();
    }
}
