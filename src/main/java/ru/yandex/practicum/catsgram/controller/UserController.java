package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 22.01.2024
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final Map<String, User> users = new HashMap<>();

    @PostMapping
    public User create(@RequestBody User user) {
        log.debug("Сохранение нового пользователя: {}", user);
        userValidate(user);
        checkUserExist(user);
        users.put(user.getEmail(), user);
        return user;
    }

    @GetMapping
    public List<User> getAll() {
        log.info("Текущее количество пользователей: {}", users.size());
        return new ArrayList<>(users.values());
    }

    @PutMapping
    public User update(@RequestBody User user) {
        userValidate(user);
        users.put(user.getEmail(), user);
        return user;
    }

    private void userValidate(User user) {
        String email = user.getEmail();
        if (email == null || email.isBlank()) {
            throw new InvalidEmailException("Email already exists.");
        }
    }

    private void checkUserExist(User user) {
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists.");
        }
    }
}
