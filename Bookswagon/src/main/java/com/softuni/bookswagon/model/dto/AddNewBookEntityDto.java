package com.softuni.bookswagon.model.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddNewBookEntityDto implements Serializable {
    private String title;

    private String author;

    private String description;

    private String publisher;

    private LocalDate publish_date;

    private String isbn;

    private String language;

    private Integer pages;

    private String bookImageUrl;
}