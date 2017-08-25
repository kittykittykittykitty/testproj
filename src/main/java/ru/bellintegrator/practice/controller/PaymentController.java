package ru.bellintegrator.practice.controller;

import ru.bellintegrator.practice.view.PaymentView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface PaymentController {

    String ping();

    ResponseData<List<PaymentView>> payments();
}
