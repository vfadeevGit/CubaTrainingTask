package com.company.cubatraining.web.screens.repair;

import com.company.cubatraining.entity.CarServiceCenter;
import com.company.cubatraining.entity.Employee;
import com.company.cubatraining.web.screens.employee.EmployeeBrowseWithParentCarService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.screen.*;
import com.company.cubatraining.entity.Repair;

import javax.inject.Inject;

@UiController("cubatraining_Repair.edit")
@UiDescriptor("repair-edit.xml")
@EditedEntityContainer("repairDc")
@LoadDataBeforeShow
public class RepairEdit extends StandardEditor<Repair> {
    @Inject
    private Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private LookupPickerField<Employee> employeeField;
    @Inject
    private LookupField<CarServiceCenter> carAutoService;

    @Subscribe("employeeField.lookup")
    public void onEmployeeFieldLookup(Action.ActionPerformedEvent event) {
        EmployeeBrowseWithParentCarService screen = screenBuilders.lookup(employeeField)
                .withScreenClass(EmployeeBrowseWithParentCarService.class)
                .withField(employeeField)
                .build();
        screen.setParentCarServiceCenter(carAutoService.getValue());
        screen.show();
    }

}