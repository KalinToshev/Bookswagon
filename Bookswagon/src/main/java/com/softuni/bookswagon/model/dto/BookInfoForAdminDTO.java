package com.softuni.bookswagon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookInfoForAdminDTO {
    private Long id;

    private String title;

    private String author;

    private String description;

    private LocalDate publish_date;

    private String isbn;

    private String language;

    private Integer pages;
}
