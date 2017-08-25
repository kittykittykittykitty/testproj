package ru.bellintegrator.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.PaymentDao;
import ru.bellintegrator.practice.model.Payment;
import ru.bellintegrator.practice.service.PaymentService;
import ru.bellintegrator.practice.view.PaymentView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class PaymentServiceImpl implements PaymentService {

    private final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final PaymentDao dao;

    @Autowired
    public PaymentServiceImpl(PaymentDao dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public ResponseData<List<PaymentView>> payments(){

        List<Payment> all = dao.all();

        Function<Payment,PaymentView> mapPayments = p ->{
            PaymentView view = new PaymentView(
                    String.valueOf(p.getId()),
                    p.getName(),
                    p.getPrice()
            );

            log.info(view.toString());

            return view;
        };

        ResponseData<List<PaymentView>> response = new ResponseData<>();
        response.data = all.stream()
                .map(mapPayments)
                .collect(Collectors.toList());

        return response;
    }





}
