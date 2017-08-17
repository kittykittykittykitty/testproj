package ru.bellintegrator.practice.controller;

import ru.bellintegrator.practice.view.CurrencyView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface CurrencyController {

    String ping();

    ResponseData<List<CurrencyView>> currencies();
}
