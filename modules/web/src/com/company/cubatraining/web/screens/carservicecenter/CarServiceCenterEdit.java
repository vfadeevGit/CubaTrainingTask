package com.company.cubatraining.web.screens.carservicecenter;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.CarServiceCenter;

@UiController("cubatraining_CarServiceCenter.edit")
@UiDescriptor("car-service-center-edit.xml")
@EditedEntityContainer("carServiceCenterDc")
@LoadDataBeforeShow
public class CarServiceCenterEdit extends StandardEditor<CarServiceCenter> {
}