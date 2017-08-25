package ru.bellintegrator.practice.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.OrganizationController;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.ResponseData;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/organizations", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final Logger log = LoggerFactory.getLogger(OrganizationControllerImpl.class);

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    @RequestMapping(value = "/ping", method = {GET, POST})
    public String ping() {
        return "pong";
    }

    @Override
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "GET")
    @RequestMapping(value = "/list", method = {GET})
    public ResponseData<List<OrganizationView>> organizations() {
        return organizationService.organizations();
    }

    @RequestMapping("/databaseError1")
    String throwDatabaseException1() throws SQLException {
        log.info("Throw SQLException");
        throw new SQLException();
    }


}