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
    @Column(name = "name", nullable = false, length = 256)
    private String name;

    /**
     * Цена услуги
     */
    @Column(name = "price", nullable = false)
    private float price;

    /**
     * Список квитанций для мапинга
     */
    @ManyToMany(targetEntity = ru.bellintegrator.practice.model.Bill.class, mappedBy = "bill_id")
    public List<Bill> bills = new ArrayList<>();

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
