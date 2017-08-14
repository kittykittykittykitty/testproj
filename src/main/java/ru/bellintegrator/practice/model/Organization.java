package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Organizations")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Version
    private int version;

    @Column(name = "organization_name", nullable = false, length = 256)
    private String name;

    @Column(name = "legal_address", nullable = false, length = 256)
    private String legalAddress;

    @Column(name="inn", nullable = false, length = 10)
    private int INN;

    @Column(name="inn", nullable = false, length = 13)
    private int OGRN;


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

    public int getINN() {
        return INN;
    }

    public void setINN(int INN) {
        this.INN = INN;
    }

    public int getOGRN() {
        return OGRN;
    }

    public void setOGRN(int OGRN) {
        this.OGRN = OGRN;
    }

}
