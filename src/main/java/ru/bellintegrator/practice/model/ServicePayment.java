package ru.bellintegrator.practice.model;

import javax.persistence.*;

/**
 *Список услуг
 */
@Entity(name = "ServicePayment")
public class ServicePayment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Version
    private int version;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

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

    public String getServiceName() {
        return serviceName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}

