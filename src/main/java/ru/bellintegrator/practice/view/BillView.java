package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;

public class BillView {

    @ApiModelProperty(hidden = true)
    public Integer id;

    public String customer;

    public String manager;

    //для jackson
    public BillView() {
    }

    public BillView(Integer id, String customer, String manager) {
        this.id = id;
        this.customer = customer;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";customer:" + customer + ";manager" + manager + "}";
    }


}

