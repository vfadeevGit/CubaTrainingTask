package com.company.cubatraining.web.screens.city;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.City;

import javax.inject.Inject;

@UiController("cubatraining_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
    @Inject
    private Notifications notifications;

    @Inject
    protected CollectionLoader<City> citiesDl;

    @Inject
    protected GroupTable<City> citiesTable;

    @Install(to = "citiesTable.edit", subject = "afterCloseHandler")
    private void citiesTableEditAfterCloseHandler(AfterCloseEvent afterCloseEvent) {

        //just tested the method getSingleSelected()
        City city = citiesTable.getSingleSelected();
        citiesDl.load();

        notifications.create(Notifications.NotificationType.TRAY)
                .withCaption("City GroupTable data Collection "+city.getName()+" updated")
                .show();
    }
}