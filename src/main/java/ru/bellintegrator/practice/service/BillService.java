package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.view.BillView;

import java.util.List;

public interface BillService {
    void add(BillView bill);

    List<BillView> bills();
}
