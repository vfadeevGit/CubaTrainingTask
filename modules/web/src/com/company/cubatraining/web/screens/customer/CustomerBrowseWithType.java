package com.company.cubatraining.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Customer;

@UiController("cubatraining_CustomerWithType.browse")
@UiDescriptor("customer-browse-with-Type.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowseWithType extends StandardLookup<Customer> {
}