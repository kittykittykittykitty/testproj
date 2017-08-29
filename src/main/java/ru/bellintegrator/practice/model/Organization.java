package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Организация
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Version
    private int version;

    /**
     * Название организации
     */
    @Column(name = "organization_name")
    private String name;

    /**
     * Адресс организации
     */
    @Column(name = "legal_address")
    private String legalAddress;

    /**
     * ИНН
     */
    @Column(name="inn")
    private String inn;

    /**
     * ???
     */
    @Column(name="ogrn")
    private String ogrn;


    public int getId() {
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

    public void setOrganizationName(String name) {
        this.name = name;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }
}
