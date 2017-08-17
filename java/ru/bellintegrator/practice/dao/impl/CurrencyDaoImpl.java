package ru.bellintegrator.practice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dao.CurrencyDao;
import ru.bellintegrator.practice.model.Currency;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CurrencyDaoImpl implements CurrencyDao{

    private final EntityManager em;

    @Autowired
    public CurrencyDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Currency> all(){
        TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c", Currency.class);
        return query.getResultList();
    }
}
