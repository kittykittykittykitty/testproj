package ru.bellintegrator.practice.service.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.ServicePayment;
import ru.bellintegrator.practice.service.Service.ServicePaymentDAO;
import ru.bellintegrator.practice.model.ServicePayment

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @{inheritDoc}
 */

@Repository
public class ServicePaymentDaoImpl implements ServicePaymentDAO {

    private final EntityManager em;

    @Autowired
    public ServicePaymentDaoImpl(EntityManager em) {
        this.em = em;
    }

    public List<ServicePayment> all() {
        TypedQuery<ServicePayment> query = em.createQuery("SELECT s FROM ServicePayment s", ServicePayment.class);
    }

    public ServicePayment loadById() {

    }

    public ServicePayment loadByName() {

    }
}

