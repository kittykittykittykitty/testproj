package ru.bellintegrator.practice.service.ReciptForPayment;

import ru.bellintegrator.practice.model.ReceiptForPayment;

import java.util.List;

public interface ReceiptForPaymentDAO {

    /**
     * get all receipts
     * @return
     */
    List<ReceiptForPayment> all();

    /**
     * get receipt by id
     * @return
     */
    ReceiptForPayment loadById();

    /**
     * get receipt by name
     * @return
     */
    ReceiptForPayment loadByName();
}
