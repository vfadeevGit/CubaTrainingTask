package com.company.cubatraining.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Company;

@UiController("cubatraining_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
}