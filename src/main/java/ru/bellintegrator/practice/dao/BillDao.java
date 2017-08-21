package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.model.Bill;

import java.util.List;

public interface BillDao {

    List<Bill> all();

    Bill loadById(Long id);

    void save(Bill bill);

}
