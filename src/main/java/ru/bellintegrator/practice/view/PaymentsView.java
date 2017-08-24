package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Bill;

import java.util.List;

public class PaymentsView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public float price;

    public List<Bill> bills;

    //for jackson
    public PaymentsView(){
    }

    public PaymentsView(String id, String name, float price, List<Bill> bills){
        this.id = id;
        this.name = name;
        this.price = price;
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "{id:" + id +
                "; name:" +
                name + "; price:" +
                price +
                ";bills:"+ bills +
                "}";
    }
}
