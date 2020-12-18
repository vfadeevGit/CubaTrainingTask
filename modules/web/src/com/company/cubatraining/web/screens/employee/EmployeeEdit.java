package com.company.cubatraining.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Employee;

@UiController("cubatraining_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
}