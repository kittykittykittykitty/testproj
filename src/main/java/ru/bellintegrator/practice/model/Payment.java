package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Услуга
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    /**
     * Название услуги
     */
    @Column(name = "name")
    private String name;

    /**
     * Цена услуги
     */
    @Column(name = "price")
    private Float price;

    @ManyToMany(mappedBy = "payments", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Bill> bills = new ArrayList<>(0);


    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Integer getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Payment(Integer id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Payment(Integer version, String name, Float price, List<Bill> bills) {
        this.version = version;
        this.name = name;
        this.price = price;
        this.bills = bills;
    }

    public Payment() {
        this.id = null;
        this.name = null;
        this.price = null;
        this.bills = null;
    }
}