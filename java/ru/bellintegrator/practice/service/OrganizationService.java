package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OrganizationsView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;


public interface OrganizationService {

    ResponseData<List<OrganizationsView>> organizations();

}
