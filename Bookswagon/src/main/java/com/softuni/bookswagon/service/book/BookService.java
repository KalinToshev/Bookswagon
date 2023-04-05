package com.softuni.bookswagon.service.book;

import com.softuni.bookswagon.model.dto.*;
import com.softuni.bookswagon.model.entity.BookEntity;

import java.util.List;

public interface BookService {
    void addBook(AddNewBookEntityDto addNewBookEntityDto);

    List<BookSummaryDTO> getAllBooksSummary();

    List<BookSummaryDTO> getAllSavedBooksOfUser(String username);

    FullBookInfoDTO findFullBookInfoByBookId(Long id);

    List<BookInfoForAdminDTO> findAllBooksAndMapForAdminPanel();

    void deleteBookById(Long id);

    void addBookToUserRepo(Long bookId, String username);

    BookEntity findBookById(Long id);
}
