package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@DiscriminatorValue("NONE")
@Table(name = "CUBATRAINING_CUSTOMER")
@Entity(name = "cubatraining_Customer")
@NamePattern("%s|name")
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 4588690893075184637L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    @CaseConversion
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    @Email(message = "{msg://cubatraining_Customer.email.validation.Email}")
    private String email;

    @JoinTable(name = "CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"))
    @ManyToMany
    private List<CarServiceCenter> carServiceCenters;

    public List<CarServiceCenter> getCarServiceCenters() {
        return carServiceCenters;
    }

    public void setCarServiceCenters(List<CarServiceCenter> carServiceCenters) {
        this.carServiceCenters = carServiceCenters;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}