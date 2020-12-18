package com.company.cubatraining.web.screens.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.City;

@UiController("cubatraining_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
}