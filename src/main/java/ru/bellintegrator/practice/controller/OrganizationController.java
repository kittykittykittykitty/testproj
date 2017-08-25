package ru.bellintegrator.practice.controller;


import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface OrganizationController {

    String ping();

    ResponseData<List<OrganizationView>> organizations();
}
