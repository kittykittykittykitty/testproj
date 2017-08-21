package ru.bellintegrator.practice.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.BillController;
import ru.bellintegrator.practice.service.BillService;
import ru.bellintegrator.practice.view.BillView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/bills", produces = APPLICATION_JSON_VALUE)
public class BillControllerImpl implements BillController{

    private final Logger log = LoggerFactory.getLogger(BillControllerImpl.class);

    private final BillService billService;

    private final TaskExecutor executor;

    @Autowired
    public BillControllerImpl(BillService billService, TaskExecutor executor) {
        this.billService = billService;
        this.executor = executor;
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
    public void bill(@RequestBody BillView person) {
        billService.add(person);
    }

    @Override
    @ApiOperation(value = "getPersons", nickname = "getPersons", httpMethod = "GET")
    @RequestMapping(value = "/list", method = {GET})
    public List<BillView> bills() {
        return billService.bills();
    }




}