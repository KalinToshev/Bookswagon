package com.softuni.bookswagon.model.dto;

import com.softuni.bookswagon.validation.annotation.UniqueEmail;
import com.softuni.bookswagon.validation.annotation.UniqueUsername;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.softuni.bookswagon.util.ValidationMessages.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserEntityDTO {
    @Size(message = FIRST_NAME_SIZE, min = 2, max = 50)
    @NotBlank(message = FIRST_NAME_NOT_BLANK)
    private String firstName;

    @NotBlank(message = LAST_NAME_NOT_BLANK)
    @Size(message = LAST_NAME_SIZE, min = 2, max = 50)
    private String lastName;

    @NotBlank(message = USERNAME_NOT_BLANK)
    @Size(message = USERNAME_SIZE, min = 3, max = 20)
    @UniqueUsername
    private String username;

    @NotBlank(message = EMAIL_NOT_BLANK)
    @Email(message = EMAIL_INVALID_FORMAT)
    @Size(message = EMAIL_SIZE, max = 100)
    @UniqueEmail
    private String email;

    @NotBlank(message = PASSWORD_NOT_BLANK)
    @Size(min = 8, max = 20, message = PASSWORD_SIZE)
    private String password;

    @NotBlank(message = CONFIRM_PASSWORD_NOT_BLANK)
    @Size(min = 8, max = 20, message = CONFIRM_PASSWORD_SIZE)
    private String confirmPassword;
}