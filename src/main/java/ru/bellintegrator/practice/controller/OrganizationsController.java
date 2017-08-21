package ru.bellintegrator.practice.controller;


import ru.bellintegrator.practice.view.OrganizationsView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;

public interface OrganizationsController {

    String ping();

    ResponseData<List<OrganizationsView>> organizations();
}
