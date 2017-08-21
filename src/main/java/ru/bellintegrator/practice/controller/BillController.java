package ru.bellintegrator.practice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.view.BillView;

import java.util.List;

public interface BillController {

    String ping();

    void bill(@RequestBody BillView bill);

    List<BillView> bills();


}
