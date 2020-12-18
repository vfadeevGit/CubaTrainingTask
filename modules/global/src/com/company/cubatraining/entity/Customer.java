package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@DiscriminatorValue("NONE")
@Table(name = "CUBATRAINING_CUSTOMER")
@Entity(name = "cubatraining_Customer")
@NamePattern("%s|name")
@DiscriminatorColumn(name = "customerType", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 4588690893075184637L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

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