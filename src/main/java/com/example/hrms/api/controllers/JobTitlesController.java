package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job-titles") //
public class JobTitlesController {

    private JobTitleService jobTitleService;
    @Autowired  // JTManager jtm = new JTManager to jobTitleService  : IoC
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getAll-jobTitles") // api/job-titles/getAll
   /* public List<JobTitle> getAll() {
        return this.jobTitleService.getAll();
    }*/

    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.add(jobTitle);
    }

/*    @GetMapping("/getByJobTitle/")
    public DataResult<JobTitle> getByJobTitle(@RequestParam String title){
        return this.jobTitleService.getByJobTitle(title);
    }*/
}
