package ru.bellintegrator.practice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dao.BillDao;
import ru.bellintegrator.practice.model.Bill;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BillDaoImpl implements BillDao{


    private final EntityManager em;

    @Autowired
    public BillDaoImpl(EntityManager em) {
            this.em = em;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public List<Bill> all() {
            TypedQuery<Bill> query = em.createQuery("SELECT b FROM Bill b", Bill.class);
            return query.getResultList();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Bill loadById(Long id) {
            return em.find(Bill.class, id);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void save(Bill bill) {
            em.persist(bill);
    }
}
