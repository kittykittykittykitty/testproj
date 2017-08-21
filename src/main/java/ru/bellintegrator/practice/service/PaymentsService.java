package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.view.PaymentsView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface PaymentsService {
    /**
     * получить список всех услуг
     * @return
     */
    ResponseData<List<PaymentsView>> payments();
}
