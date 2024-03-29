package com.softuni.bookswagon.validation.annotation;

import com.softuni.bookswagon.validation.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "Username already exists.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}