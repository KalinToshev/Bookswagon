package com.softuni.bookswagon.validation.annotation;

import com.softuni.bookswagon.validation.UniqueBookTitleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueBookTitleValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueBookTitle {
    String message() default "Book with this title already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
