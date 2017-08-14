package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity(name = "Currency")
public class Currency {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;

    @Version
    private int version;

    @Column(name = "currency_code")
    private int currencyCode;

    @Column(name = "currency_name")
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
