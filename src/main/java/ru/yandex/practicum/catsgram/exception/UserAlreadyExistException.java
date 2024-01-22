package ru.yandex.practicum.catsgram.exception;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 22.01.2024
 */
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
