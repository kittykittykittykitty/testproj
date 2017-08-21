package ru.bellintegrator.practice.model;

import javax.persistence.*;

/**
 * Услуга
 */
@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "price", nullable = false)
    private float price;


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
