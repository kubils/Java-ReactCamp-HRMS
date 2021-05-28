package com.example.hrms.api.controllers;


import com.example.hrms.business.abstracts.EmployerUserService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employers")
public class EmployerUsersController {

    private EmployerUserService employersUserService;

    @Autowired
    public EmployerUsersController(EmployerUserService employersUserService) {
        this.employersUserService = employersUserService;
    }

    @GetMapping("getall/employers")
    public DataResult<List<Employers>> getAll() {return this.employersUserService.getAll();}

    @PostMapping("/add/employers")
    public Result add(@RequestBody Employers employers) {
        return this.employersUserService.add(employers);
    }

}
