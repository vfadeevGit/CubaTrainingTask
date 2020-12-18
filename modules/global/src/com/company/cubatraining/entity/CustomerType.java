package com.company.cubatraining.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CustomerType implements EnumClass<Integer> {

    COMPANY_TYPE(10),
    INDIVIDUAL_TYPE(20),
    NONE_TYPE(30);

    private Integer id;

    CustomerType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static CustomerType fromId(Integer id) {
        for (CustomerType at : CustomerType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}