package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.model.Bill;
import ru.bellintegrator.practice.view.BillView;

import java.util.List;

public interface BillService {
    /**
     * Добавить квитанцию
     * @param bill
     */
    void add(BillView bill);

    /**
     * Получить список квитанций
     * @return
     */
    List<BillView> bills();

    /**
     * Детальный просмотр квитанции
     * @param id
     * @return
     */
    BillView bill(Long id); //    TODO детальный просмотр квитанции
}
