package ru.bellintegrator.practice.dao;

import ru.bellintegrator.practice.model.Organization;

import java.util.List;

public interface OrganizationDaо {

    /**
     * Получить списсок всех организаций
     * @return
     */
    List<Organization> all();
}
