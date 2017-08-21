package ru.bellintegrator.practice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dao.PaymentsDao;
import ru.bellintegrator.practice.model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PaymentsDaoImpl implements PaymentsDao{

    private final EntityManager em;

    @Autowired
    public PaymentsDaoImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Payment> all() {
        TypedQuery<Payment> query = em.createQuery("SELECT p FROM Payment p", Payment.class);
        return query.getResultList();
    }
}
