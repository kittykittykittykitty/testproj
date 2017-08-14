package ru.bellintegrator.practice.controller;


import ru.bellintegrator.practice.view.OrganizationsView;

import java.util.List;

public interface OrganizationsController {

    String ping();

    void organization();

    List<OrganizationsView> organizations();
}
