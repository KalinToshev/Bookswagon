package com.softuni.bookswagon.repository;

import com.softuni.bookswagon.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    void deleteByBookEntity_Id(Long bookId);
}