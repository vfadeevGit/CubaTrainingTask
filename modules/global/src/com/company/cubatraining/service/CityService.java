package com.company.cubatraining.service;


import com.company.cubatraining.entity.City;

import java.util.List;
import java.util.UUID;

public interface CityService {

    String NAME = "cubatraining_CityService";

    List<City> getDefaultCity();

    boolean resetDefaultCity(UUID editedCityId);

    void dropDefaultCity(City city);
}