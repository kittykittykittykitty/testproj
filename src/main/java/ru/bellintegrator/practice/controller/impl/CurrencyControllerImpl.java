package ru.bellintegrator.practice.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.CurrencyController;
import ru.bellintegrator.practice.service.CurrencyService;
import ru.bellintegrator.practice.view.CurrencyView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/currency", produces = APPLICATION_JSON_VALUE)
public class CurrencyControllerImpl implements CurrencyController{

    private final Logger log = LoggerFactory.getLogger(CurrencyControllerImpl.class);

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyControllerImpl(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @Override
    @RequestMapping(value = "/ping", method = {GET, POST})
    public String ping() {
        return "pong";
    }

    @Override
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiOperation(value = "getCurrency", nickname = "getCurrency", httpMethod = "GET")
    @RequestMapping(value = "/list", method = {GET})
    public ResponseData<List<CurrencyView>> currencies(){
        return currencyService.currencies();
    }
}
