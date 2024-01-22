package ru.yandex.practicum.catsgram.exception;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 22.01.2024
 */
public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
