package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.model.Payment;

import java.util.List;

public interface PaymentDao {
    /**
     * получить список всех услуг
     * @return
     */
    List<Payment> all();
}
