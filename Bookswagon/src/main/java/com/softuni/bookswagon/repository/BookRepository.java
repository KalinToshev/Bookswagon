package com.softuni.bookswagon.repository;

import com.softuni.bookswagon.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findBookEntityByTitle(String title);

    BookEntity findBookEntityByIsbn(String ISBN);

    void deleteBookEntityById(Long id);
}