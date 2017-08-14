package ru.bellintegrator.practice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.view.CurrenciesResponse;
import ru.bellintegrator.practice.view.CurrencyView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/api/dictionary")
public class CurrencyController {

//    @Autowired
//    private CurrencyService currencyService;

    @RequestMapping(path = "currency", method = RequestMethod.GET)
    public CurrenciesResponse currencies() {
        CurrenciesResponse response = new CurrenciesResponse();
        List<CurrencyView> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CurrencyView view = new CurrencyView();
            view.code = i;
            view.name = "name" + i;
            data.add(view);
        }
        response.setData(data);
        return response;
    }
}
