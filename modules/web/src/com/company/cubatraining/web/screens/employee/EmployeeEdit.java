package com.company.cubatraining.web.screens.employee;

import com.company.cubatraining.entity.CarServiceCenter;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Employee;

import javax.inject.Inject;
import javax.mail.Session;

@UiController("cubatraining_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {

    @Subscribe
    public void onInit(InitEvent event) {
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<Employee> event) {


    }
}