package com.company.cubatraining.web.screens.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.City;

@UiController("cubatraining_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {
}