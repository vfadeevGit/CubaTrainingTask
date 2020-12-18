package com.company.cubatraining.web.screens.individual;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Individual;

@UiController("cubatraining_Individual.edit")
@UiDescriptor("individual-edit.xml")
@EditedEntityContainer("individualDc")
@LoadDataBeforeShow
public class IndividualEdit extends StandardEditor<Individual> {
}