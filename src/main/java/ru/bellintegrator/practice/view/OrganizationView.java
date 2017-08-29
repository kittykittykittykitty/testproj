package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;


public class OrganizationView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public String legalAddress;

    public String inn;

    public String ogrn;

    //for jackson
    public OrganizationView() {
    }

    public OrganizationView(String id, String name, String legalAddress, String inn, String ogrn) {
        this.id = id;
        this.name = name;
        this.legalAddress = legalAddress;
        this.inn = inn;
        this.ogrn = ogrn;
    }

    @Override
    public String toString() {
        return "{id:" + id + "; name:" + name + "; legalAddress:" + legalAddress + "; inn:" + inn + "; ogrn:" + ogrn + "}";
    }

}
