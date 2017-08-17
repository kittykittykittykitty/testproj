package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.model.Currency;

import java.util.List;

public interface CurrencyDao {

    /**
     * Получить список всех валют.
     * @return
     */
    List<Currency> all();
}
