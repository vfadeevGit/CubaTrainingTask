package com.company.cubatraining.web.screens.city;

import com.company.cubatraining.service.CityService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.DialogAction;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.City;
import sun.awt.AppContext;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@UiController("cubatraining_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {

    @Inject
    private CityService cityService;
    @Inject
    private Notifications notifications;
    @Inject
    private Dialogs dialogs;
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onAfterCommitChanges(AfterCommitChangesEvent event) {

        City thisEntity = getEditedEntityContainer().getItem();
        try {
            if (thisEntity.getIsDefaultCity())
            {
                //Service reset Application variant
            /*if (cityService.resetDefaultCity(thisEntity.getId()))
                notifications.create(Notifications.NotificationType.TRAY)
                        .withCaption("Default cityies checkup dropped in database");

             */

                // UI using datamanger application variant
                localContextResetDefaultCity(thisEntity.getId());
            }
        } catch (Exception e)
        {
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("Default city checkbox not checked");
        }

    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPreCommit(DataContext.PreCommitEvent event) {
        for (Entity<City> city : event.getModifiedInstances())
        {
            if (cityService.checkCityWithNameExists(city.getValue("cityName"), city.getValue("id"))) {
                notifications.create(Notifications.NotificationType.TRAY)
                        .withCaption("Alert")
                        .withDescription("City with name "+city.getValue("cityName")+ " already exists! Entity not saved")
                        .show();
                event.preventCommit();
            }
        }
    }

    public void localContextResetDefaultCity(UUID editedEntityId) {

        List<City> cityList = dataManager.load(City.class)
                .query("select e from cubatraining_City e where e.isDefaultCity = TRUE and e.id <> :editedEntityId")
                .parameter("editedEntityId", editedEntityId)
                .view("city-view-browse")
                .list()
                ;

        CommitContext commitContext = new CommitContext();
        if (!cityList.isEmpty()) {
            for (City city : cityList) {
                city.setIsDefaultCity(false);
                commitContext.addInstanceToCommit(city);
            }
        }
        dataManager.commit(commitContext);
    }

}