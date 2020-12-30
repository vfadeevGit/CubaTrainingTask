package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "CUBATRAINING_REPAIR")
@Entity(name = "cubatraining_Repair")
@NamePattern("%s|description")
public class Repair extends StandardEntity {
    private static final long serialVersionUID = -2307046670080191116L;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    @Lob
    private String description;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_SERVICE_CENTER_ID")
    private CarServiceCenter carServiceCenter;

    public CarServiceCenter getCarServiceCenter() {
        return carServiceCenter;
    }

    public void setCarServiceCenter(CarServiceCenter carServiceCenter) {
        this.carServiceCenter = carServiceCenter;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}