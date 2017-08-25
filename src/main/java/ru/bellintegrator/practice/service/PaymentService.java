package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.view.PaymentView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface PaymentService {
    /**
     * получить список всех услуг
     * @return
     */
    ResponseData<List<PaymentView>> payments();
}
