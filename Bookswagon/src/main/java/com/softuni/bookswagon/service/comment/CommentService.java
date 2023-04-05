package com.softuni.bookswagon.service.comment;

import com.softuni.bookswagon.model.dto.AddCommentDTO;
import com.softuni.bookswagon.model.dto.ShowCommentDTO;

import java.util.List;

public interface CommentService {
    void addComment(AddCommentDTO addCommentDTO);

    List<ShowCommentDTO> getAllCommentsForBook(Long id);

    void deleteCommentsByBookId(Long id);
}
