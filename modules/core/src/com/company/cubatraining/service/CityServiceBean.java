package com.company.cubatraining.service;

import com.company.cubatraining.entity.City;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    DataManager dataManager;

    @Override
    public Optional<City> getDefaultCity() {

        return null;
    }

}