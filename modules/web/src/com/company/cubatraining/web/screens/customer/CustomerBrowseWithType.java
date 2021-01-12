package com.company.cubatraining.web.screens.customer;

import com.company.cubatraining.entity.Company;
import com.company.cubatraining.entity.Individual;
import com.haulmont.cuba.core.entity.KeyValueEntity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Customer;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@UiController("cubatraining_CustomerWithType.browse")
@UiDescriptor("customer-browse-with-Type.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowseWithType extends StandardLookup<Customer> {

    @Inject
    private DataManager dataManager;

    private List<KeyValueEntity> listRelatedAttributes;
    @Inject
    private Notifications notifications;

    @Subscribe
    public void onInit(InitEvent event) {
        listRelatedAttributes = dataManager.loadValues(
                "select DISTINCT a, (CASE WHEN a.id = i.id THEN i.passportNo ELSE c.inn END) from cubatraining_Customer a, cubatraining_Company c, cubatraining_Individual i " +
                        "where a.id=c.id or a.id=i.id")
                .properties("customer","addInfo")
                .list();

    }

    @Install(to = "customersTable.type", subject = "columnGenerator")
    private Component customersTableTypeColumnGenerator(Customer customer) {
        String customerType, addInfo = "";
        Boolean notFound = true;
        ListIterator<KeyValueEntity> it = listRelatedAttributes.listIterator();
        while (it.hasNext() && notFound) {
            KeyValueEntity object = it.next();
            if (object.getValue("customer").equals(customer)) {
                notFound = false;
                addInfo = object.getValue("addInfo");
            }
        }
        if (Company.class.isInstance(customer)) {
            customerType = "Company";
        } else
        {
            customerType = "Individual";
        }
        //customerType+= " / "+addInfo;
        return new Table.PlainTextCell(customerType);
    }

    @Install(to = "customersTable.inn", subject = "columnGenerator")
    private Component customersTableInnColumnGenerator(Customer customer) {

        String companyInn = "-";
        if (Company.class.isInstance(customer)) {
            companyInn = dataManager.load(Company.class)
                    .query("select a from cubatraining_Company a where a.id = :customerId")
                    .view("company-view-only-inn")
                    .parameter("customerId", customer.getUuid())
                    .one().getInn();
        }

        return new Table.PlainTextCell(companyInn);
    }

    @Install(to = "customersTable.passportNo", subject = "columnGenerator")
    private Component customersTablePassportNoColumnGenerator(Customer customer) {

        String individualPassportNo = "-";
        if (Individual.class.isInstance(customer)) {
            individualPassportNo = dataManager.load(Individual.class)
                    .query("select a from cubatraining_Individual a where a.id = :customerId")
                    .view("individual-view-only-passportNo")
                    .parameter("customerId", customer.getUuid())
                    .one().getPassportNo();
        }

        return new Table.PlainTextCell(individualPassportNo);
    }

}