package com.company.cubatraining.service;

import com.company.cubatraining.entity.City;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    DataManager dataManager;
    @Inject
    private Persistence persistence;

    @Override
    public List<City> getDefaultCity() {
        return dataManager.load(City.class)
                .query("select e from cubatraining_City e where e.isDefaultCity = TRUE")
                .view("city-view-browse")
                .list();
    }

    @Override
    public boolean resetDefaultCity(UUID currentCityId) {
        boolean ifFoundAnotherDefCity = false;

        try (Transaction tx = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            List<City> cityList = entityManager.createQuery("select e from cubatraining_City e where e.isDefaultCity = TRUE and e.id <> :editedEntityId")
                    .setParameter("editedEntityId", currentCityId)
                    .getResultList();
            if (!cityList.isEmpty()) {
                ifFoundAnotherDefCity = true;
                cityList.forEach(city -> dropDefaultCity(city));
            }
            tx.commit();
        }
        return ifFoundAnotherDefCity;
    }

    @Override
    public void dropDefaultCity(City entityCity){
        entityCity.setIsDefaultCity(false);
    }

}