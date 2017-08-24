package ru.bellintegrator.practice.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Bill;
import ru.bellintegrator.practice.model.Currency;
import ru.bellintegrator.practice.model.Payment;

import java.util.Date;
import java.util.List;

public class BillView {

    @ApiModelProperty(hidden = true)
    public Integer id;

    public String customer;

    public String phone;

    public String manager;

    public String number;

    public Date date;

    public Currency curId;

    public List<Payment> payments;

    //для jackson
    public BillView() {
    }

    public BillView(Integer id, String number, String customer, String phone, String manager, Date date, Currency curId, List<Payment> payments) {
        this.id = id;
        this.number = number;
        this.customer = customer;
        this.phone = phone;
        this.manager = manager;
        this.date = date;
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "{id:" + id +
                "billNumber:" + number +
                ";customer:" + customer +
                ";phone:" + phone +
                ";manager:" + manager +
                ";date:" + date +
                ";currencyId:" + curId +
                ";payemnts:" + payments +
                "}";
    }

}

