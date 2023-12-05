package ru.netology.exception;

public class  NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("ru.netology.domain.Player " + name + " not registered");
    }
}
