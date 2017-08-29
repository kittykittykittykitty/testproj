package ru.bellintegrator.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.BillDao;
import ru.bellintegrator.practice.model.Bill;
import ru.bellintegrator.practice.service.BillService;
import ru.bellintegrator.practice.view.BillView;
import ru.bellintegrator.practice.model.Payment;
import ru.bellintegrator.practice.view.PaymentView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class BillServiceImpl implements BillService {

    private final Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

    private final BillDao dao;

    @Autowired
    public BillServiceImpl(BillDao dao) {
        this.dao = dao;
    }


    public List<Payment> convertToPayment(List<PaymentView> paymentView){
        List<Payment> payments = new ArrayList<>();
        for(PaymentView pv : paymentView) {
            Payment payment = new Payment(pv.id, pv.name, pv.price);
            payments.add(payment);
        }
        return payments;
    }

    public List<PaymentView> convertToPaymentView(List<Payment> payments){
        List<PaymentView> paymentsView = new ArrayList<>();
        for(Payment p : payments){
            PaymentView paymentView = new PaymentView(p.getId(), p.getName(), p.getPrice());
            paymentsView.add(paymentView);
        }
        return paymentsView;
    }

    public BillView convertToBillView(Bill bill){
        BillView billView = new BillView(
                bill.getId(),
                bill.getNumber(),
                bill.getCustomer(),
                bill.getPhone(),
                bill.getManager(),
                bill.getDate(),
                bill.getCurId(),
                convertToPaymentView(bill.getPayments()),
                bill.getOrgId()
        );
        return billView;
    }

    @Override
    @Transactional
    public void add(BillView view) {
        List<Payment> payments = convertToPayment(view.payments);
        Bill bill = new Bill(view.id, view.number, view.customer, view.phone, view.manager, view.date, view.curId, view.orgId, payments);
        dao.save(bill);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BillView> bills() {

        List<Bill> all = dao.all();

        Function<Bill, BillView> mapBill = b -> {

            BillView view = new BillView();

            view.id = b.getId();
            view.number = b.getNumber();
            view.customer = b.getCustomer();
            view.phone = b.getPhone();
            view.manager = b.getManager();
            view.date = b.getDate();
            view.curId = b.getCurId();
            view.payments = convertToPaymentView(b.getPayments());
            view.orgId = b.getOrgId();

            log.debug(view.toString());

            return view;
        };

        return all.stream()
                .map(mapBill)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BillView bill(Long id){
        Bill b = dao.loadById(id);
        return convertToBillView(b);
    }
}
