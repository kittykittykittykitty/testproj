package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Валюта
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @Column(name = "currency_code")
    private String currencyCode;

    /**
     * Наименование валюты
     */
    @Column(name = "currency_name")
    private String currencyName;

    public Integer getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}