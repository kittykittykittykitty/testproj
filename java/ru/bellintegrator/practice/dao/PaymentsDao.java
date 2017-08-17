package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.model.Payment;

import java.util.List;

public interface PaymentsDao {
    /**
     * получить список всех услуг
     * @return
     */
    List<Payment> all();
}
