package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.model.Organization;

import java.util.List;

public interface OrganizationDaо {

    /**
     * Получить списсок всех организаций
     *
     * @return
     */
    List<Organization> all();

    /**
     * загрузить организацию по id
     *
     * @param id
     * @return
     */
    Organization loadById(int id);


    /**
     * получить организацию по имени
     *
     * @param name
     * @return
     */
    Organization loadByName(String name);
}
