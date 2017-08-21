package ru.bellintegrator.practice.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException(String msg, Throwable t) {
        super(msg, t);
    }
}
