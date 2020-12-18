package com.company.cubatraining.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Company;

@UiController("cubatraining_Company.browse")
@UiDescriptor("company-browse.xml")
@LookupComponent("companiesTable")
@LoadDataBeforeShow
public class CompanyBrowse extends StandardLookup<Company> {
}