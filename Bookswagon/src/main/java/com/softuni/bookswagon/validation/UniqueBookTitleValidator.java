package com.softuni.bookswagon.validation;

import com.softuni.bookswagon.model.entity.BookEntity;
import com.softuni.bookswagon.repository.BookRepository;
import com.softuni.bookswagon.validation.annotation.UniqueBookTitle;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueBookTitleValidator implements ConstraintValidator<UniqueBookTitle, String> {
    private final BookRepository bookRepository;

    @Autowired
    public UniqueBookTitleValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void initialize(UniqueBookTitle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        BookEntity book = this.bookRepository.findBookEntityByTitle(title);
        return book == null;
    }
}
