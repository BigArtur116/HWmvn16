package ru.netology.javaqa95.HWmvn16.services;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String massege) {
        super(massege);
    }
}
