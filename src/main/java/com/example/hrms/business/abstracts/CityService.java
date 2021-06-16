package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
    Result add(City city);
}
