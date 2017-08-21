package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Bill")
public class Bill {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Integer id;

    @Version
    private int version;

    @Column(name = "customer")
    private String customer;

    @Column(name = "manager")
    private String manager;

    public Bill(Integer id, String customer, String manager) {
        this.id = id;
        this.customer = customer;
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

}
