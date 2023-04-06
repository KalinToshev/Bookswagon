package com.softuni.bookswagon.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.softuni.bookswagon.util.CommentValidationMessages.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentDTO {
    @Size(message = CONTENT_SIZE, min = 20, max = 350)
    @NotBlank(message = CONTENT_NOT_BLANK)
    private String content;

    private String authorUsername;

    private Long bookId;
}
