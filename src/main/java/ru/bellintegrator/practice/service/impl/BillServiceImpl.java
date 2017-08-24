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

    @Override
    @Transactional
    public void add(BillView view) {
        Bill bill = new Bill(view.id, view.number, view.customer, view.phone, view.manager, view.date, view.curId, view.payments);
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
            view.payments = b.getPayments();

            log.debug(view.toString());

            return view;
        };

        return all.stream()
                .map(mapBill)
                .collect(Collectors.toList());
    }

}
