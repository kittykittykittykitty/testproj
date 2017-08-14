package ru.bellintegrator.practice.model;

import org.h2.store.Data;

import javax.persistence.*;

/**
 * Квитанция об оплате
 */
@Entity(name = "ReceiptForPayment")
public class ReceiptForPayment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Version
    private int version;

    /**
     * № квитанции
     * Формат - цифры, буквы и знаки "-"
     */
    @Column(name = "receipt_number", nullable = false, length = 64)
    private String receiptNumber;

    /**
     * ФИО заказчик
     */
    @Column(name = "customer_name", nullable = false, length = 64)
    private String customerName;

    /**
     * телефон заказчика
     */
    @Column(name = "customer_phone_number", nullable = false, length = 32)
    private String customerPhoneNumber;

    /**
     * лицо, совершившее оплату
     */
    @Column(name = "payment_customer", nullable = false, length = 64)
    private String paymentCustomer;

    /**
     * менеджер, принявший оплату
     */
    @Column(name = "payment_manager", nullable = false, length = 64)
    private String paymentManager;

    /**
     * дата платежа
     */
    @Column(name = "payment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Data paymentDate;

    /**
     * валюта платежа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_currency_id")
    private Currency paymentCurrency;
    
    //TODO Organization ManyToOne
    //TODO Service ManyToMany

    public Integer getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getPaymentCustomer() {
        return paymentCustomer;
    }

    public void setPaymentCustomer(String paymentCustomer) {
        this.paymentCustomer = paymentCustomer;
    }

    public String getPaymentManager() {
        return paymentManager;
    }

    public void setPaymentManager(String paymentManager) {
        this.paymentManager = paymentManager;
    }

    public Data getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Data paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Currency getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(Currency paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }
}
