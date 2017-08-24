package ru.bellintegrator.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.PaymentsDao;
import ru.bellintegrator.practice.model.Payment;
import ru.bellintegrator.practice.service.PaymentsService;
import ru.bellintegrator.practice.view.CurrencyView;
import ru.bellintegrator.practice.view.PaymentsView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class PaymentsServiceImpl implements PaymentsService{

    private final Logger log = LoggerFactory.getLogger(PaymentsServiceImpl.class);

    private final PaymentsDao dao;

    @Autowired
    public  PaymentsServiceImpl(PaymentsDao dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public ResponseData<List<PaymentsView>> payments(){

        List<Payment> all = dao.all();

        Function<Payment,PaymentsView> mapPayments = p ->{
            PaymentsView view = new PaymentsView(
                    String.valueOf(p.getId()),
                    p.getName(),
                    p.getPrice(),
                    p.getBills()
            );

            log.info(view.toString());

            return view;
        };

        ResponseData<List<PaymentsView>> response = new ResponseData<>();
        response.data = all.stream()
                .map(mapPayments)
                .collect(Collectors.toList());

        return response;
    }





}
