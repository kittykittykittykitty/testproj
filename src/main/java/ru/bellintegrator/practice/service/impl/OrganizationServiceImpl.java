package ru.bellintegrator.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.dao.OrganizationDaо;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.ResponseData;

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

    @Override
    @Transactional
    public ResponseData<List<OrganizationView>> organizations() {

        List<Organization> all = dao.all();

        Function<Organization, OrganizationView> mapOrganization = org -> {
            OrganizationView view = new OrganizationView(
                    String.valueOf(org.getId()),
                    org.getName(),
                    org.getLegalAddress(),
                    org.getInn(),
                    org.getOgrn()
            );

            log.info(view.toString());

            return view;
        };

        ResponseData<List<OrganizationView>> response = new ResponseData<>();
        response.data = all.stream()
                .map(mapOrganization)
                .collect(Collectors.toList());

        return response;
    }
}

