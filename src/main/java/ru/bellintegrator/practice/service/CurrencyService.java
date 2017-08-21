package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.view.CurrencyView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface CurrencyService {
    ResponseData<List<CurrencyView>> currencies();
}
