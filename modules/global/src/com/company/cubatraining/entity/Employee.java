package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "CUBATRAINING_EMPLOYEE", indexes = {
        @Index(name = "IDX_CUBATRAINING_EMPLOYEE", columnList = "LAST_NAME")
})
@Entity(name = "cubatraining_Employee")
@NamePattern("%s %s|firstName,lastName")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = 6348086566532573971L;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    @NotNull
    private LocalDate birthDate;

    @Column(name = "EMAIL")
    @Email(message = "{msg://cubatraining_Employee.email.validation.Email}")
    private String email;

    @NumberFormat(pattern = "$0.00", decimalSeparator = ".")
    @Column(name = "SALARY")
    @Positive
    @DecimalMin("0")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_SERVICE_CENTER_ID")
    @NotNull
    private CarServiceCenter carServiceCenter;

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public CarServiceCenter getCarServiceCenter() {
        return carServiceCenter;
    }

    public void setCarServiceCenter(CarServiceCenter carServiceCenter) {
        this.carServiceCenter = carServiceCenter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}