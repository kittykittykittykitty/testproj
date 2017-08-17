package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Currency")
public class Currency {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Integer id;

    @Version
    private int version;

    /**
     * Код валюты
     */
    @Column(name = "currency_code", nullable = false, length = 50)
    private int currencyCode;

    /**
     * Наименование валюты
     */
    @Column(name = "currency_name", nullable = false, length = 50)
    private String currencyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}