package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.WorkTypeService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/workType")
public class WorkTypeController {
    private WorkTypeService workTypeService;

    @Autowired
    public WorkTypeController(WorkTypeService workTypeService) {
        this.workTypeService = workTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkType>> getAll() {
        return this.workTypeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkType workType) {
        return this.workTypeService.add(workType);
    }

}
