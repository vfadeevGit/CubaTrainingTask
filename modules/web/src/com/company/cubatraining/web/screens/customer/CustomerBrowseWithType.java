package com.company.cubatraining.web.screens.customer;

import com.company.cubatraining.entity.Company;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Customer;

import javax.inject.Inject;

@UiController("cubatraining_CustomerWithType.browse")
@UiDescriptor("customer-browse-with-Type.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowseWithType extends StandardLookup<Customer> {

    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onInit(InitEvent event) {

    }

    @Install(to = "customersTable.type", subject = "columnGenerator")
    private Component customersTableTypeColumnGenerator(Customer customer) {
        String customerType = "";
        if (Company.class.isInstance(customer)) {
            customerType = "Company";
        } else
        {
            customerType = "Individual";
        }
        return new Table.PlainTextCell(customerType);
    }

}