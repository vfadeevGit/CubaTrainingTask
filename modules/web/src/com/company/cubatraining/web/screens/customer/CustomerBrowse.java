package com.company.cubatraining.web.screens.customer;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Customer;

import javax.inject.Inject;

@UiController("cubatraining_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
    @Inject
    private CollectionContainer<Customer> customersDc;
}