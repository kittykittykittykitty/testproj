package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationsView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public String legalAddress;

    public int INN;

    public int OGRN;

    public OrganizationsView() {

    }

    public OrganizationsView(String name, String legalAddress, int INN, int OGRN) {
        this.name = name;
        this.legalAddress = legalAddress;
        this.INN = INN;
        this.OGRN = OGRN;
    }

    @Override
    public String toString() {
        return "{id:" + id + "; name:" + name + "; legalAddress:" + legalAddress + "; INN:" + INN + "; OGRN:" + OGRN + "}";
    }

}
