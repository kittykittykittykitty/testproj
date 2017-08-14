package ru.bellintegrator.practice.service.Service;

import ru.bellintegrator.practice.model.ServicePayment;
import java.util.List;


public interface ServicePaymentDAO {

    /**
     * get all services
     * @return
     */
    List<ServicePayment> all();

    /**
     * get service by id
     * @return
     */
    ServicePayment loadById();

    /**
     * get service by name
     * @return
     */
    ServicePayment loadByName();
}
