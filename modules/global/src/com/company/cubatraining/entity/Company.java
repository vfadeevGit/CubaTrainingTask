package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.DiscriminatorValue("COMP")
@Table(name = "CUBATRAINING_COMPANY")
@Entity(name = "cubatraining_Company")
@NamePattern("%s|inn")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Company extends Customer {
    private static final long serialVersionUID = -6993518614085924686L;

    @Column(name = "INN", nullable = false, unique = true)
    @NotNull
    private String inn;

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}