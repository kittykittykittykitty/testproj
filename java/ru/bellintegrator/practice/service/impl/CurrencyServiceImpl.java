package ru.bellintegrator.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.CurrencyDao;
import ru.bellintegrator.practice.model.Currency;
import ru.bellintegrator.practice.service.CurrencyService;
import ru.bellintegrator.practice.view.CurrencyView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class CurrencyServiceImpl implements CurrencyService{

    private final Logger log = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    private final CurrencyDao dao;

    @Autowired
    public CurrencyServiceImpl(CurrencyDao dao){
        this.dao = dao;
    }

    @Override
    @Transactional
    public ResponseData<List<CurrencyView>> currencies(){

        List<Currency> all = dao.all();

        Function<Currency,CurrencyView> mapCurrency = c ->{
            CurrencyView view = new CurrencyView(
                    String.valueOf(c.getId()),
                    c.getCurrencyName(),
                    c.getCurrencyCode()
            );

            log.info(view.toString());

            return view;
        };

        ResponseData<List<CurrencyView>> response = new ResponseData<>();
        response.data = all.stream()
                .map(mapCurrency)
                .collect(Collectors.toList());

        return response;
    }
}


/*



 */
