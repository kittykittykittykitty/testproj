package ru.bellintegrator.practice.view;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    private T data;
    private List<String> errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error) {
        if (data != null) {
            data = null;
        }

        if (errors == null) {
            errors = new ArrayList<>();
        }

        errors.add(error);
    }
}
