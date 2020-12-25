package com.company.cubatraining.listeners;

import com.company.cubatraining.entity.City;
import com.company.cubatraining.service.CityService;
import com.company.cubatraining.service.CityServiceBean;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Messages;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;


@Component("cubatraining_CityChangedListener")
public class CityChangedListener {

    @Inject
    private CityService cityService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<City, UUID> event) {

        AttributeChanges changes = event.getChanges();
        if (changes.isChanged("isDefaultCity")) {
            Boolean preDefaultCityStatus = changes.getOldValue("isDefaultCity");
            if (!preDefaultCityStatus) {
                Boolean resResetDefaultCity = cityService.resetDefaultCity(event.getEntityId().getValue());
            }
        }

    }

}