package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.WorkTimeService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/worktime")
public class WorkTimeController {
    private WorkTimeService workTimeService;

    @Autowired
    public WorkTimeController(WorkTimeService workTimeService) {
        this.workTimeService = workTimeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkTime>> getAll() {
        return this.workTimeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkTime workTime) {
        return this.workTimeService.add(workTime);
    }

}
