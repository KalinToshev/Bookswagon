package com.softuni.bookswagon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookSummaryDTO {
    private Long id;

    private String bookImageUrl;

    private String title;

    private String description;
}
