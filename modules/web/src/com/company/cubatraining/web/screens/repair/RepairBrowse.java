package com.company.cubatraining.web.screens.repair;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Repair;

@UiController("cubatraining_Repair.browse")
@UiDescriptor("repair-browse.xml")
@LookupComponent("repairsTable")
@LoadDataBeforeShow
public class RepairBrowse extends StandardLookup<Repair> {
}