package com.company.cubatraining.web.screens.carservicecenter;

import com.company.cubatraining.entity.City;
import com.company.cubatraining.entity.Customer;
import com.company.cubatraining.entity.Employee;
import com.company.cubatraining.service.CityService;
import com.haulmont.chile.core.model.Session;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.CarServiceCenter;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@UiController("cubatraining_CarServiceCenter.edit")
@UiDescriptor("car-service-center-edit.xml")
@EditedEntityContainer("carServiceCenterDc")
@LoadDataBeforeShow
public class CarServiceCenterEdit extends StandardEditor<CarServiceCenter> {
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;
    @Inject
    private EntityStates entityStates;
    @Inject
    protected CityService cityService;
    @Inject
    private TabSheet tabSheet;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private UserSession userSession;

    @Install(to = "customerTable.type", subject = "columnGenerator")
    private Component customerTableTypeColumnGenerator(Customer customer) {
        Label<String> customerType = uiComponents.create(Label.TYPE_STRING);
        customerType.setValue(customer.getCustomerType().trim().contains("COMP")  ? "Company" : "Individual");
        return customerType;
    }

    @Install(to = "employeesTable.create", subject = "initializer")
    private void employeesTableCreateInitializer(Employee employee) {
        /* Before understanding of DataCollection Inheritance
        String serviceMessage = getEditedEntity().getNameService();
        notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption(serviceMessage)
                .show();*/
        //employee.setCarServiceCenter(getEditedEntity());
    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPostCommit(DataContext.PostCommitEvent event) {
        //FIXME Check if it works or not
        if (!event.getCommittedInstances().isEmpty()) {
            tabSheet.getTab("tabEmployees").setEnabled(true);
            tabSheet.getTab("tabCustomers").setEnabled(true);
            tabSheet.getTab("tabRepairs").setEnabled(true);
        }
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<CarServiceCenter> event) {
        event.getEntity().setAuthor(userSession.getUser());
        List<City> defaultCityList = cityService.getDefaultCity();
        if (!defaultCityList.isEmpty()) {
            event.getEntity().setCity(defaultCityList.get(0));
        } else {
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("No default City assigned")
                    .show();
        }
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        if (entityStates.isNew(getEditedEntity())) {
            tabSheet.getTab("tabEmployees").setEnabled(false);
            tabSheet.getTab("tabCustomers").setEnabled(false);
            tabSheet.getTab("tabRepairs").setEnabled(false);
        }
    }

    @Subscribe(id = "customerDc", target = Target.DATA_CONTAINER)
    public void onCustomerDcCollectionChange(CollectionContainer.CollectionChangeEvent<Customer> event) {
        CarServiceCenter thisCarServiceCenter = getEditedEntity();
        if (!entityStates.isNew(thisCarServiceCenter)) {
            int countRows = getEditedEntity().getEmployees().size();
            tabSheet.getTab("tabCustomers").setCaption("Customers ("+countRows+")");
        }
     }

}