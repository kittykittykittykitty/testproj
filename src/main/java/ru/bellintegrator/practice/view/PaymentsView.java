package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;

public class PaymentsView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public float price;

    //for jackson
    public PaymentsView(){
    }

    public PaymentsView(String id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{id:" + id + "; name:" + name + "; price:" + price + "}";
    }
}
