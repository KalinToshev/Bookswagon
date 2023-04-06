package com.softuni.bookswagon.model.entity;

import com.softuni.bookswagon.model.enums.RateEnum;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rates")
public class RateEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "rate", nullable = false)
    private RateEnum rate;

    @Column(name = "author_username", nullable = false)
    private String authorUsername;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    private BookEntity book;
}