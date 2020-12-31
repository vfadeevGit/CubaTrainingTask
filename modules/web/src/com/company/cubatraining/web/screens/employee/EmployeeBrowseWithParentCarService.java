package com.company.cubatraining.web.screens.employee;

import com.company.cubatraining.entity.CarServiceCenter;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Employee;

import javax.inject.Inject;

@UiController("cubatraining_Employee_with_Parent_CarService.browse")
@UiDescriptor("employee-browse-with-Parent-CarService.xml")
@LookupComponent("employeesTable")
public class EmployeeBrowseWithParentCarService extends StandardLookup<Employee> {

    public CarServiceCenter parentCarServiceCenter;
    @Inject
    private CollectionLoader<Employee> employeesDl;

    public void setParentCarServiceCenter(CarServiceCenter parentCarServiceCenter) {
        this.parentCarServiceCenter = parentCarServiceCenter;}

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        employeesDl.setParameter("parentCarServiceCenter",parentCarServiceCenter);
        employeesDl.load();
    }



}