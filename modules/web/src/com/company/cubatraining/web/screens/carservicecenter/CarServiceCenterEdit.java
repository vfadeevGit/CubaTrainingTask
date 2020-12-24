package com.company.cubatraining.web.screens.carservicecenter;

import com.company.cubatraining.entity.City;
import com.company.cubatraining.entity.Customer;
import com.company.cubatraining.entity.Employee;
import com.company.cubatraining.service.CityService;
import com.haulmont.chile.core.model.Session;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.CarServiceCenter;

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
    private DataContext dataContext;
    @Inject
    protected CityService cityService;
    @Inject
    private TabSheet tabSheet;
    @Inject
    private UiComponents uiComponents;

    public Component generateCustomerType(Customer entity) {
        //Try PlainTextCell here for faster response
        Label<String> customerType = uiComponents.create(Label.TYPE_STRING);
        customerType.setValue(entity.getCustomerType().trim().contains("COMP")  ? "Company" : "Individual");
        return customerType;
    }

    @Install(to = "employeesTable.create", subject = "initializer")
    private void employeesTableCreateInitializer(Employee employee) {
        /* Before understanding of DataCollection Inheritanca
        String serviceMessage = getEditedEntity().getNameService();
        notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption(serviceMessage)
                .show();*/
        //employee.setCarServiceCenter(getEditedEntity());
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<CarServiceCenter> event) {
        List<City> defaultCityList = cityService.getDefaultCity();
        if (!defaultCityList.isEmpty()) {
            event.getEntity().setCity(defaultCityList.get(0));
        } else {
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("No default City assigned")
                    .show();
        }
    }

    @Subscribe(id = "customerDc", target = Target.DATA_CONTAINER)
    public void onCustomerDcCollectionChange(CollectionContainer.CollectionChangeEvent<Customer> event) {
        //int countRows = dataManager.load(Employee.class).query("select e from cubatraining_customer where e.id = :entityId")
        //        .parameter("entityId",getEditedEntity().getUuid())
        //        .list()
        //        .size();

        int countRows = getEditedEntity().getEmployees().size();
        tabSheet.getTab("tabCustomers").setCaption("Customers ("+countRows+")");

        /*notifications.create(Notifications.NotificationType.TRAY)
                .withCaption("Customer Data Collection Event, customer rows count " + countRows)
                .show();

         */
    }

}