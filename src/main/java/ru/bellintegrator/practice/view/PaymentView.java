package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Bill;
import ru.bellintegrator.practice.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentView {

    @ApiModelProperty(hidden = true)
    public Integer id;

    public String name;

    public Float price;


    //for jackson
    public PaymentView(){
    }

    public PaymentView(String name, Float price){
        this.name = name;
        this.price = price;
    }

    public PaymentView(Integer id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{id:" + id +
                "; name:" +
                name + "; price:" +
                price +
                "}";
    }
}
