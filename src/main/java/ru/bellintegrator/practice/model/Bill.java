package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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
    private Long id;

    @Version
    private int version;

    /**
     * Номер квитанции
     */
    @Column(name = "number")
    private String number;

    /**
     * Имя клиента
     */
    @Column(name = "customer")
    private String customer;

    /**
     * Номер телефона клиента
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Имя менеджера
     */
    @Column(name = "manager")
    private String manager;

    /**
     * Дата оплаты
     */
    @Column(name = "date")
    private Date date;

    /**
     * Идентификатор валюты
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cur_id")
    private Currency curId;


    /**
     * Идентификатор компании
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization orgId;

    /**
     * Список услуг
     */
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="BILL_PAYMENTS",
            joinColumns=
            @JoinColumn(name="bills_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="payments_id", referencedColumnName="id")
    )
    private List<Payment> payments = new ArrayList<>(0);



    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Bill(Long id, String number, String customer, String phone, String manager, Date date, Currency curId, Organization orgId,  List<Payment> payments) {
        this.id = id;
        this.number = number;
        this.customer = customer;
        this.phone = phone;
        this.manager = manager;
        this.date = date;
        this.curId = curId;
        this.orgId = orgId;
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
        this.orgId = null;
        this.payments = null;
    }


    public Organization getOrgId() {
        return orgId;
    }

    public void setOrgId(Organization orgId) {
        this.orgId = orgId;
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

    public Long getId() {
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

