package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.JobTitle;
import com.example.hrms.entities.concretes.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsPostController {

    private JobPostService jobPostService;

    @Autowired
    public JobsPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping("/add-job")
    public Result add(@RequestBody Jobs job) {
        return this.jobPostService.add(job);
    }

    @PostMapping("/jobs/setJobDisabled")
    public DataResult<Jobs> setJobDisabled(@RequestParam int id) {
        return this.jobPostService.setJobDisabled(id);
    }

    @GetMapping("/getAll-jobs")
    public DataResult<List<Jobs>> getAll() {
        return this.jobPostService.getAll();
    }

    @GetMapping("/getByActivitySituation")
    public DataResult<List<Jobs>> getByIsActive(@RequestParam boolean isActive) {
        return this.jobPostService.getByIsActive(isActive);
    }

    @GetMapping("/getByEmployersId")
    public DataResult<List<Jobs>> getByEmployersId(@RequestParam int employerId) {
        return this.jobPostService.getByEmployer_Id(employerId);
    }

    @GetMapping("/getByIsActiveAndEmployerId")
    public DataResult<List<Jobs>> getByIsActiveAndEmployer_Id(@RequestParam int employerId) {
        return this.jobPostService.findByActiveTrueAndEmployers(employerId);
    }

    @GetMapping("/getByDate_Of_OpenAndIsActive")
    public DataResult<List<Jobs>> getByDate_Of_OpenAndIsActive() {
        return this.jobPostService.findByIs_ActiveTrueOrderByDate_Of_Open();
    }
}
