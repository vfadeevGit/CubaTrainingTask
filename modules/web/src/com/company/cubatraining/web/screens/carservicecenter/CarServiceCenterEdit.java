package com.company.cubatraining.web.screens.carservicecenter;

import com.company.cubatraining.entity.City;
import com.company.cubatraining.entity.Employee;
import com.company.cubatraining.service.CityService;
import com.company.cubatraining.web.screens.employee.EmployeeEdit;
import com.haulmont.chile.core.model.Session;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.CarServiceCenter;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
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
    private Session session;
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionPropertyContainer<Employee> employeesDc;
    @Inject
    protected CityService cityService;

    @Install(to = "employeesTable.create", subject = "initializer")
    private void employeesTableCreateInitializer(Employee employee) {
        /*String serviceMessage = getEditedEntity().getNameService();
        notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption(serviceMessage)
                .show();*/
        //employee.setCarServiceCenter(getEditedEntity());
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<CarServiceCenter> event) {
        List<City> defaultCityList = cityService.getDefaultCity();
        if (!defaultCityList.isEmpty()) {
            event.getEntity().setCity(defaultCityList.get(0));}
        else {
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("No default City assigned")
                    .show();
        };
    }

}