package ru.bellintegrator.practice.view;


import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Currency;

public class CurrencyView {

    @ApiModelProperty(hidden = true)
    public Integer id;

    public String currencyName;

    public String currencyCode;

    //for jackson
    public CurrencyView() {
    }

    public CurrencyView(Integer id, String currencyCode, String currencyName){
        this.id = id;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
    }

    @Override
    public String toString(){
        return "{id:" + id + "; currency name:" + currencyName + "; currency code:" + currencyCode + "}";
    }
}
