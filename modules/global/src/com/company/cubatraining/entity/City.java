package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "CUBATRAINING_CITY", indexes = {
        @Index(name = "IDX_CUBATRAINING_CITY", columnList = "CITY_NAME")
})
@Entity(name = "cubatraining_City")
@NamePattern("%s|cityName")
public class City extends StandardEntity {
    private static final long serialVersionUID = -4783880174132504705L;

    @NotNull
    @Column(name = "CITY_NAME", nullable = false, unique = true)
    @NotEmpty(message = "{msg://cubatraining_City.cityName.validation.NotEmpty}")
    private String cityName;

    @Column(name = "IS_DEFAULT_CITY")
    private Boolean isDefaultCity;

    @Column(name = "CITY_CODE")
    private String cityCode;

    public Boolean getIsDefaultCity() {
        return isDefaultCity;
    }

    public void setIsDefaultCity(Boolean isDefaultCity) {
        this.isDefaultCity = isDefaultCity;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}