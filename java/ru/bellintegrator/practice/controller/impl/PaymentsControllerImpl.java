package ru.bellintegrator.practice.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.PaymentsController;
import ru.bellintegrator.practice.service.PaymentsService;
import ru.bellintegrator.practice.view.PaymentsView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/payments", produces = APPLICATION_JSON_VALUE)
public class PaymentsControllerImpl implements PaymentsController{

    private final Logger log = LoggerFactory.getLogger(PaymentsControllerImpl.class);

    private final PaymentsService paymentsService;

    @Autowired
    public PaymentsControllerImpl(PaymentsService paymentsService){
        this.paymentsService = paymentsService;
    }

    @Override
    @RequestMapping(value = "/ping", method = {GET, POST})
    public String ping() {
        return "pong";
    }

    @Override
    @ApiOperation(value = "getPayemnts", nickname = "getPayments", httpMethod = "GET")
    @RequestMapping(value = "/list", method = {GET})
    public ResponseData<List<PaymentsView>> payments(){
        return paymentsService.payments();
    }

}
