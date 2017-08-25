package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.bellintegrator.practice.view.PaymentView;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Квитанция
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Bill")
public class Bill {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Integer id;

    @Version
    private int version;

    /**
     * Номер квитанции
     */
    @Column(name = "number")
    @NotNull(message = "Номер квитанции должен быть задан")
    @Size(min = 6, max = 10)
    @Pattern(regexp = "^[^\\W_]+$")
    private String number;

    /**
     * Имя клиента
     */
    @Column(name = "customer")
    @NotNull
    @Size(max = 256)
    @Pattern(regexp = "^[a-zA-Z\\s]*$")
    private String customer;

    /**
     * Номер телефона клиента
     */
    @Column(name = "phone")
    @NotNull
    @Size(max = 20)
    @Pattern(regexp = "(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]\u200C\u200B)\\s*)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)([2-9]1[02-9]\u200C\u200B|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})\\s*(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+)\\s*)?$")
    private String phone;

    /**
     * Имя менеджера
     */
    @Column(name = "manager")
    @Pattern(regexp = "^[a-zA-Z\\s]*$")
    @Size(max = 256)
    @NotNull
    private String manager;

    /**
     * Дата оплаты
     */
    @Column(name = "date")
    @NotNull
    private Date date;

    /**
     * Идентификатор валюты
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cur_id")
    private Currency curId;


    /**
     * СПИСОК УСЛУГ TODO
     * Many to many relation for payyments
     * @return
     */
    @ManyToMany(targetEntity = ru.bellintegrator.practice.model.Payment.class)
    public List<PaymentView> payments = new ArrayList<>();

    public List<PaymentView> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentView> payments) {
        this.payments = payments;
    }

    public Bill(Integer id, String number, String customer, String phone, String manager, Date date, Currency curId, List<PaymentView> payments) {
        this.id = id;
        this.number = number;
        this.customer = customer;
        this.phone = phone;
        this.manager = manager;
        this.date = date;
        this.curId = curId;
        this.payments = payments;
    }

    public Bill() {
        this.id = null;
        this.number = null;
        this.customer = null;
        this.phone = null;
        this.manager = null;
        this.date = null;
        this.curId = null;
        this.payments = null;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurId() {
        return curId;
    }

    public void setCurId(Currency curId) {
        this.curId = curId;
    }
}

/*
post example
curl localhost:8888/bills/addbill -H "Content-Type: application/json" -X POST -d '{"number":"111A111", "customer":"Customer Cuustomer Rrrr", "phone":"1 800 5551212", "manager":"Manager Manager Manager", "date":"2012-09-17", "curId":{"id":"1"}}'
 */

