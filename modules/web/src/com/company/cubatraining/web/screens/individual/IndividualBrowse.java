package com.company.cubatraining.web.screens.individual;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Individual;

@UiController("cubatraining_Individual.browse")
@UiDescriptor("individual-browse.xml")
@LookupComponent("individualsTable")
@LoadDataBeforeShow
public class IndividualBrowse extends StandardLookup<Individual> {
}