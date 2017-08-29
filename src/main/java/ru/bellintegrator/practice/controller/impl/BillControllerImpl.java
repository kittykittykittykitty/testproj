package ru.bellintegrator.practice.controller.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.BillController;
import ru.bellintegrator.practice.model.Bill;
import ru.bellintegrator.practice.model.Payment;
import ru.bellintegrator.practice.service.BillService;
import ru.bellintegrator.practice.validator.BillValidator;
import ru.bellintegrator.practice.view.BillView;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/bills", produces = APPLICATION_JSON_VALUE)
public class BillControllerImpl implements BillController{

    private final Logger log = LoggerFactory.getLogger(BillControllerImpl.class);


    private BillService billService;

    @Autowired
    private BillValidator billValidator;

    @Autowired
    public BillControllerImpl(BillService billService) {
        this.billService = billService;
    }


    @Override
    @RequestMapping(value = "/ping", method = {GET, POST})
    public String ping() {
        return "pong";
    }

    @Override
    @ApiOperation(value = "addBill", nickname = "addBill", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/addbill", method = {POST})
    public String bill(@RequestBody BillView bill, BindingResult result) {
        billValidator.validate(bill, result);
        if (result.hasErrors()) {
            return "data is wrong";
        }
        billService.add(bill);
        return "Success";
    }


    @Override
    @ApiOperation(value = "getBills", nickname = "getBills", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/list", method = {GET})
    public List<BillView> bills() {
        return billService.bills();
    }


    @Override
    @ApiOperation(value = "getBill", nickname = "getBill", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/{id}", method = {GET})
    public BillView bill( @PathVariable("id") Long id){
        return billService.bill(id);
    }
}
