package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "CUBATRAINING_CITY", indexes = {
        @Index(name = "IDX_CUBATRAINING_CITY_UNQ", columnList = "NAME")
})
@Entity(name = "cubatraining_City")
@PublishEntityChangedEvents
@NamePattern("%s|name")
public class City extends StandardEntity {
    private static final long serialVersionUID = -4783880174132504705L;

    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "IS_DEFAULT")
    private Boolean isDefault = false;

    @Column(name = "CODE", unique = true)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}