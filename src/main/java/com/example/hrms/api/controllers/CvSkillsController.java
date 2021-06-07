package com.example.hrms.api.controllers;


import com.example.hrms.business.abstracts.CvSkillService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/skills")
public class CvSkillsController {

    private CvSkillService cvSkillService;

    @Autowired
    public CvSkillsController(CvSkillService cvSkillService) {
        this.cvSkillService = cvSkillService;
    }

    @PostMapping("/add/")
    public Result add(@Valid @RequestBody CvSkills skill) {
        return this.cvSkillService.add(skill);
    }

    @GetMapping("/getByCandidates_Id")
    public DataResult<List<CvSkills>> getByCandidates_Id(int candidateId) {
        return this.cvSkillService.getSkillsByCandidates_Id(candidateId);
    }
}
