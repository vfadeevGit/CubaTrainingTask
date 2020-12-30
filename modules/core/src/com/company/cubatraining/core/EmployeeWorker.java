package com.company.cubatraining.core;

import com.company.cubatraining.entity.Employee;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.security.app.Authenticated;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

@Component("cubatraining_EmployeeWorker")
public class EmployeeWorker implements EmployeeWorkerMBean {

    @Inject
    private TimeSource timeSource;
    @Inject
    private DataManager dataManager;
    @Inject
    private EmailService emailService;
    @Inject
    private Scripting scripting;

    @Authenticated
    @Override
    public List<String> sendGreetings(String senderEmail) {
        List<String> resList = new ArrayList<>();
        //нужна транзакция
        try {
            List<Employee> employeeList = dataManager.load(Employee.class).query(
                    "select e from cubatraining_Employee e where (function('DAYOFMONTH',e.birthDate) = function('DAYOFMONTH',:todayDayMonth)) and (function('MONTH',e.birthDate) = function('MONTH',:todayDayMonth))")
            .parameter("todayDayMonth",timeSource.currentTimestamp()).list();
            employeeList.forEach(employee -> {
                groovy.lang.Binding binding = new Binding();
                binding.setVariable("nameId", employee.getFirstName()+" "+employee.getLastName());
                binding.setVariable("age", timeSource.now().getYear()-employee.getBirthDate().getYear());
                String scriptGreetings = scripting.runGroovyScript("com/company/cubatraining/EmployeeEmailText.groovy",binding).toString();
                EmailInfo emailInfo = new EmailInfo(
                        employee.getEmail(),
                        "Car Service Manager Happy Birthday Greetings!",
                        null,
                        scriptGreetings,
                        null
                );
                emailService.sendEmailAsync(emailInfo);
                resList.add(scriptGreetings);
            });
        } catch (Exception exception) {
            //TODO something here on exception
            resList.add(exception.getMessage());
        }
        return resList;
    }
}