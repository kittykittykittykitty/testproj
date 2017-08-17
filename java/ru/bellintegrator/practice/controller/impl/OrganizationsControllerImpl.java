package ru.bellintegrator.practice.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.controller.OrganizationsController;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationsView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/organizations", produces = APPLICATION_JSON_VALUE)
public class OrganizationsControllerImpl implements OrganizationsController {

    private final Logger log = LoggerFactory.getLogger(OrganizationsControllerImpl.class);

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationsControllerImpl(OrganizationService organizationService) {
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
    public ResponseData<List<OrganizationsView>> organizations() {
        return organizationService.organizations();
    }
}