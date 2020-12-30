package com.company.cubatraining.core;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import com.haulmont.cuba.core.sys.jmx.JmxBean;

import java.util.List;

@JmxBean(module = "cubatraining", alias = "employeeWorker")
@ManagedResource(description = "JMX bean to test Employee e-mail sender")

public interface EmployeeWorkerMBean {
    @ManagedOperation(description = "Performs Employee E-mail sender test")
    @ManagedOperationParameter(name = "senderEmail", description = "Sender E-mail field:")
    List<String> sendGreetings(String senderEmail);
}