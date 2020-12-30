package com.company.cubatraining.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "CUBATRAINING_CAR_SERVICE_CENTER", indexes = {
        @Index(name = "IDX_CUBATRAINING_CAR_SERVICE_CENTER", columnList = "NAME")
})
@Entity(name = "cubatraining_CarServiceCenter")
@NamePattern("%s %s|name,city")
public class CarServiceCenter extends StandardEntity {
    private static final long serialVersionUID = -5476964607361573601L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    @OnDeleteInverse(DeletePolicy.DENY)
    private City city;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "carServiceCenter")
    private List<Employee> employees;

    @JoinTable(name = "CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK",
            joinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    @ManyToMany
    private List<Customer> customer;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "carServiceCenter")
    private List<Repair> repair;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Repair> getRepair() {
        return repair;
    }

    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}