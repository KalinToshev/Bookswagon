package com.softuni.bookswagon.validation.annotation;

import com.softuni.bookswagon.validation.UniqueBookISBNValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueBookISBNValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueBookISBN {
    String message() default "Book with this ISBN already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
