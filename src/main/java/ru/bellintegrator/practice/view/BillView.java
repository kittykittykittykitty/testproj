package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Currency;
import ru.bellintegrator.practice.model.Organization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillView {

    @ApiModelProperty(hidden = true)
    public Long id;

    public String customer;

    public String phone;

    public String manager;

    public String number;

    public Date date;

    public Currency curId;

    public Organization orgId;

    public List<PaymentView> payments = new ArrayList<>();


    //для jackson
    public BillView() {
    }

    public BillView(Long id, String number, String customer, String phone, String manager, Date date, Currency curId, List<PaymentView> payments, Organization orgId) {
        this.id = id;
        this.number = number;
        this.customer = customer;
        this.phone = phone;
        this.manager = manager;
        this.date = date;
        this.curId = curId;
        this.payments = payments;
        this.orgId = orgId;
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
                ";payments:" + payments +
                "orgId:" + orgId +
                "}";
    }
}

