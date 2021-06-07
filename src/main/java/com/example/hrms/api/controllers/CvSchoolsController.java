package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CvSchoolService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvSchools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schools")
public class CvSchoolsController {
    private CvSchoolService cvSchoolService;

    @Autowired
    public CvSchoolsController(CvSchoolService cvSchoolService) {
        this.cvSchoolService = cvSchoolService;
    }

    @PostMapping("/add/")
    public Result add(@RequestBody CvSchools school) {
        return this.cvSchoolService.add(school);
    }

    @GetMapping("/getByDateOfFinishSorted")
    public DataResult<List<CvSchools>> getByDateOfFinishSorted(int candidateId) {
        return this.cvSchoolService.getByDateOfFinish(candidateId);
    }
}
