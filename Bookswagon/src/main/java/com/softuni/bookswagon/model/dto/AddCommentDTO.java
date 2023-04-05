package com.softuni.bookswagon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentDTO {
    private String content;

    private String authorUsername;

    private Long bookId;
}
