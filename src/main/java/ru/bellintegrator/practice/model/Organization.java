package ru.bellintegrator.practice.model;

import javax.persistence.*;

/**
 * Список организаций
 */
@Entity(name = "Organizations")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Version
    private int version;

    /**
     * Имя организации
     */
    @Column(name = "organization_name", nullable = false, length = 256)
    private String organizationName;

    /**
     * Адресс организации
     */
    @Column(name = "legal_address", nullable = false, length = 256)
    private String legalName;

    /**
     * ИНН
     */
    @Column(name = "inn", nullable = false, length = 10)
    private String inn;

    /**
     *TODO(Иван) описание
     */
    @Column(name = "ogrn", nullable = false, length = 13)
    private String ogrn;
}