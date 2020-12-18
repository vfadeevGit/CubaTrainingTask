package com.company.cubatraining.web.screens.repair;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Repair;

@UiController("cubatraining_Repair.edit")
@UiDescriptor("repair-edit.xml")
@EditedEntityContainer("repairDc")
@LoadDataBeforeShow
public class RepairEdit extends StandardEditor<Repair> {
}