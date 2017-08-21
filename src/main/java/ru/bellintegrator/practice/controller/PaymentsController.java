package ru.bellintegrator.practice.controller;

import ru.bellintegrator.practice.view.PaymentsView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface PaymentsController {

    String ping();

    ResponseData<List<PaymentsView>> payments();
}
