package ru.bellintegrator.practice.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.view.BillView;

import java.util.List;

public interface BillController {

    String ping();

    String bill(@RequestBody BillView bill, BindingResult result);

    List<BillView> bills();

    BillView bill(Long id);


}
