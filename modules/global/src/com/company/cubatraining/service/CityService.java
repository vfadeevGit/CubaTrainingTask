package com.company.cubatraining.service;


import com.company.cubatraining.entity.City;

import java.util.Optional;

public interface CityService {

    String NAME = "cubatraining_CityService";

    Optional<City> getDefaultCity();
}