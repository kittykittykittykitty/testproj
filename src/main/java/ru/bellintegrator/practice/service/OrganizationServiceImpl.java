package ru.bellintegrator.practice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OrganizationsView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {

    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDaо dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDaо dao) {
        this.dao = dao;
    }

    public List<OrganizationsView> organizations() {
        List<Organization> all = dao.all();

        Function<Organization, OrganizationsView> mapOrganization = org -> {
            OrganizationsView view = new OrganizationsView();
            view.id = String.valueOf(org.getId());
            view.name = org.getName();
            view.OGRN = org.getOGRN();
            view.INN = org.getINN();
            view.legalAddress = org.getLegalAddress();

            log.debug(view.toString());

            return view;
        };

        return all.stream()
                .map(mapOrganization)
                .collect(Collectors.toList());
    }
}

