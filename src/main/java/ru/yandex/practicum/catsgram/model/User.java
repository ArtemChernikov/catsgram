package ru.yandex.practicum.catsgram.model;

import lombok.*;

import java.time.LocalDate;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 22.01.2024
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @EqualsAndHashCode.Include
    private String email;
    private String nickname;
    private LocalDate birthdate;
}
