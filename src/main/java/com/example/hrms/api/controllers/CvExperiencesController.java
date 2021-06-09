package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CvExperienceService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvExperiences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/experience")
public class CvExperiencesController {

    private CvExperienceService cvExperienceService;

    @Autowired
    public CvExperiencesController(CvExperienceService cvExperienceService) {
        this.cvExperienceService = cvExperienceService;
    }

    @PostMapping("/add/")
    public Result add(@RequestBody CvExperiences experience) {
        return this.cvExperienceService.add(experience);
    }

    @GetMapping("/getByDateOfFinishSorted")
    public DataResult<List<CvExperiences>> getByDateOfFinishSorted(int candidateId) {
        return this.cvExperienceService.getByDateOfFinish(candidateId);
    }
}