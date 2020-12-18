package com.company.cubatraining.web.screens.carservicecenter;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.CarServiceCenter;

@UiController("cubatraining_CarServiceCenter.browse")
@UiDescriptor("car-service-center-browse.xml")
@LookupComponent("carServiceCentersTable")
@LoadDataBeforeShow
public class CarServiceCenterBrowse extends StandardLookup<CarServiceCenter> {
}