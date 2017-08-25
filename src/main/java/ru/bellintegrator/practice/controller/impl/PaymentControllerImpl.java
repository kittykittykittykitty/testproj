package ru.bellintegrator.practice.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.PaymentController;
import ru.bellintegrator.practice.service.PaymentService;
import ru.bellintegrator.practice.view.PaymentView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/payments", produces = APPLICATION_JSON_VALUE)
public class PaymentControllerImpl implements PaymentController {

    private final Logger log = LoggerFactory.getLogger(PaymentControllerImpl.class);

    private final PaymentService paymentService;

    @Autowired
    public PaymentControllerImpl(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Override
    @RequestMapping(value = "/ping", method = {GET, POST})
    public String ping() {
        return "pong";
    }

    @Override
    @ApiOperation(value = "getPayemnts", nickname = "getPayments", httpMethod = "GET")
    @RequestMapping(value = "/list", method = {GET})
    public ResponseData<List<PaymentView>> payments(){
        return paymentService.payments();
    }

}
