package ru.netology.statistic;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String e) {
        super(e);
    }
}