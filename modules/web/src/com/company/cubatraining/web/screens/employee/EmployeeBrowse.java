package com.company.cubatraining.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Employee;

@UiController("cubatraining_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}