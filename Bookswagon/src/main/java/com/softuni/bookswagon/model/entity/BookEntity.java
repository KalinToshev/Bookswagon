package com.softuni.bookswagon.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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

    @Column(name = "description", nullable = false, length = 500)
    private String description;

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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "readBooks", cascade = CascadeType.MERGE)
    private Set<UserEntity> users = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookEntity book = (BookEntity) o;
        return getId() != null && Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}