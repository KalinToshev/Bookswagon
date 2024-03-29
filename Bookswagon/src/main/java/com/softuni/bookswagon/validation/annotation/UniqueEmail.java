package com.softuni.bookswagon.validation.annotation;

import com.softuni.bookswagon.validation.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Email already exists.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
