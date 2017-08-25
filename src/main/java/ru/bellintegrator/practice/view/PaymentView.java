package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Bill;

import java.util.List;

public class PaymentView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public float price;

//    public List<Bill> bills;

    //for jackson
    public PaymentView(){
    }

    public PaymentView(String id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{id:" + id +
                "; name:" + name +
                "; price:" + price +
                "}";
    }
}
