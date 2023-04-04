package com.softuni.bookswagon.validation;

import com.softuni.bookswagon.model.entity.BookEntity;
import com.softuni.bookswagon.repository.BookRepository;
import com.softuni.bookswagon.validation.annotation.UniqueBookISBN;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueBookISBNValidator implements ConstraintValidator<UniqueBookISBN, String> {
    private final BookRepository bookRepository;

    @Autowired
    public UniqueBookISBNValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void initialize(UniqueBookISBN constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String ISBN, ConstraintValidatorContext context) {
        BookEntity book = this.bookRepository.findBookEntityByIsbn(ISBN);
        return book == null;
    }
}
