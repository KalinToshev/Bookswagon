package com.softuni.bookswagon.service.book;

import com.softuni.bookswagon.model.dto.*;

import java.util.List;

public interface BookService {
    void addBook(AddNewBookEntityDto addNewBookEntityDto);

    List<BookSummaryDTO> getAllBooksSummary();

    List<BookSummaryDTO> getAllSavedBooksOfUser(String username);

    FullBookInfoDTO findFullBookInfoByBookId(Long id);

    List<BookInfoForAdminDTO> findAllBooksAndMapForAdminPanel();

    void deleteById(Long id);

    void addBookToUserRepo(Long bookId, String username);
}
