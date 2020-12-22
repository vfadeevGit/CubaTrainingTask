package com.company.cubatraining.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Employee;

@UiController("cubatraining_Employee_withParentAutoservice.edit")
@UiDescriptor("employee-edit-with-parentAutoSrvice.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEditWithParentAutoService extends StandardEditor<Employee> {
}