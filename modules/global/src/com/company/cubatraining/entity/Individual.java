package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.DiscriminatorValue("INDIVID")
@Table(name = "CUBATRAINING_INDIVIDUAL")
@Entity(name = "cubatraining_Individual")
@NamePattern("%s|passportNo")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Individual extends Customer {
    private static final long serialVersionUID = 5836761616803951406L;

    @NotNull
    @Column(name = "PASSPORT_NO", nullable = false)
    private String passportNo;

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
}