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
    public City getDefaultCity() {
        try {
            return dataManager.load(City.class)
                    .query("select e from cubatraining_City e where e.isDefault = TRUE")
                    .view("city-view-browse")
                    .one();
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean resetDefaultCity(UUID currentCityId) {
        boolean ifFoundAnotherDefCity = false;

        try (Transaction tx = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            List<City> cityList = entityManager.createQuery("select e from cubatraining_City e where e.isDefault = TRUE and e.id <> :editedEntityId")
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
        entityCity.setIsDefault(false);
    }

    @Override
    public boolean checkCityWithNameExists(String searchName, UUID editedId) {
        List<City> cityList = dataManager.load(City.class)
                .query("select e from cubatraining_City e where e.name = :searchName and e.id <> :editedId")
                .parameter("searchName", searchName)
                .parameter("editedId", editedId)
                .view("city-view-browse")
                .list();
        return !cityList.isEmpty();
    }

}