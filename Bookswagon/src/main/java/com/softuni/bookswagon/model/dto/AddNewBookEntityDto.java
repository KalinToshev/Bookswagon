package com.softuni.bookswagon.model.dto;

import com.softuni.bookswagon.validation.annotation.UniqueBookTitle;
import com.softuni.bookswagon.validation.annotation.UniqueBookISBN;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

import static com.softuni.bookswagon.util.BookValidationMessages.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddNewBookEntityDto {
    @Size(message = TITLE_SIZE, min = 2, max = 100)
    @NotBlank(message = TITLE_NOT_BLANK)
    @UniqueBookTitle
    private String title;

    @Size(message = AUTHOR_SIZE, min = 2, max = 100)
    @NotBlank(message = AUTHOR_NOT_BLANK)
    private String author;

    @Size(message = DESCRIPTION_SIZE, min = 50, max = 500)
    @NotBlank(message = DESCRIPTION_NOT_BLANK)
    private String description;

    @NotNull(message = PUBLISH_DATE_NOT_NULL)
    @PastOrPresent(message = PUBLISH_DATE_PAST_OR_PRESENT)
    private LocalDate publish_date;

    @Size(message = ISBN_SIZE, min = 10, max = 13)
    @NotBlank(message = ISBN_NOT_BLANK)
    @UniqueBookISBN
    private String isbn;

    @Size(message = LANGUAGE_SIZE, min = 3, max = 30)
    @NotBlank(message = LANGUAGE_NOT_BLANK)
    private String language;

    @NotNull(message = PAGES_NOT_NULL)
    @Positive(message = PAGES_POSITIVE)
    private Integer pages;

    @URL(message = BOOK_IMAGE_URL_URL)
    @NotBlank(message = BOOK_IMAGE_URL_NOT_BLANK)
    private String bookImageUrl;
}