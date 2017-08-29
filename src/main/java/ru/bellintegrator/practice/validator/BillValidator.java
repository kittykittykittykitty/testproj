package ru.bellintegrator.practice.validator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import ru.bellintegrator.practice.model.Bill;

import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import org.springframework.util.StringUtils;

import javax.persistence.Column;

@Component
public class BillValidator implements Validator {

    @Override
    public void validate(Object obj, Errors errors) {
        Bill bill = (Bill) obj;
        String customer = bill.getCustomer();
        /**
         * Customer validation
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"customer", "customer.empty", "Customer name must not be empty.");

        /**
         * Manager validation
         */
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"manager", "manager.empty", "Manager name must not be empty.");

    }


    @Override
    public boolean supports(Class<?> clazz) {
    return Bill.class.isAssignableFrom(clazz);

    }
}

