package com.softuni.bookswagon.service.comment;

import com.softuni.bookswagon.model.dto.AddCommentDTO;
import com.softuni.bookswagon.model.dto.ShowCommentDTO;
import com.softuni.bookswagon.model.entity.CommentEntity;
import com.softuni.bookswagon.repository.BookRepository;
import com.softuni.bookswagon.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;

    private final BookRepository bookRepository;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public void addComment(AddCommentDTO addCommentDTO) {
        CommentEntity comment = new CommentEntity();

        comment.setContent(addCommentDTO.getContent());
        comment.setAuthorUsername(addCommentDTO.getAuthorUsername());
        comment.setBookEntity(this.bookRepository.findById(addCommentDTO.getBookId()).orElseThrow(() -> new IllegalArgumentException("A book with the given ID was not found!")));

        this.commentRepository.save(comment);
    }

    @Override
    public List<ShowCommentDTO> getAllCommentsForBook(Long id) {
        return this.commentRepository.findAll()
                .stream()
                .map(commentEntity -> {
                    ShowCommentDTO showCommentDTO = new ShowCommentDTO();
                    modelMapper.map(commentEntity, showCommentDTO);
                    return showCommentDTO;
                })
                .filter(showCommentDTO -> showCommentDTO.getBookId().equals(id))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteCommentsByBookId(Long id) {
        this.commentRepository.deleteByBookEntity_Id(id);
    }
}
