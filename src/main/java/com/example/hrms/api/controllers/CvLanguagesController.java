package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CvLanguageService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/languages")
public class CvLanguagesController {

    private CvLanguageService cvLanguageService;

    @Autowired
    public CvLanguagesController(CvLanguageService cvLanguageService) {
        this.cvLanguageService = cvLanguageService;
    }

    @PostMapping("/add/")
    public Result add(@Valid @RequestBody CvLanguages language) {
        return this.cvLanguageService.add(language);
    }


    @GetMapping("/getByCandidates_Id")
    public DataResult<List<CvLanguages>> getByCandidates_Id(int candidateId) {
        return this.cvLanguageService.getByCandidates_Id(candidateId);
    }
}
