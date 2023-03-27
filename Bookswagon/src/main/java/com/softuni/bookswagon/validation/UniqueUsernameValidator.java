package com.softuni.bookswagon.validation;

import com.softuni.bookswagon.model.entity.UserEntity;
import com.softuni.bookswagon.repository.UserRepository;
import com.softuni.bookswagon.validation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final UserRepository userRepository;

    @Autowired
    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity == null;
    }
}
