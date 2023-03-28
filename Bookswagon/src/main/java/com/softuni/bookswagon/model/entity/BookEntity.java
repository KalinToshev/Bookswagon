package com.softuni.bookswagon.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "publish_date", nullable = false)
    private LocalDate publish_date;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "book_image_url", nullable = false)
    private String bookImageUrl;
}