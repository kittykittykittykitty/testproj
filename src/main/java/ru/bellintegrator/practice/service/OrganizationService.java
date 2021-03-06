package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.ResponseData;

import java.util.List;


public interface OrganizationService {

    ResponseData<List<OrganizationView>> organizations();

}
