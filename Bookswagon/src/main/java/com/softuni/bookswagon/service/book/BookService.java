package com.softuni.bookswagon.service.book;

import com.softuni.bookswagon.model.dto.AddNewBookEntityDto;
import com.softuni.bookswagon.model.dto.BookSummaryDTO;
import com.softuni.bookswagon.model.dto.FullBookInfoDTO;

import java.util.List;

public interface BookService {
    void addBook(AddNewBookEntityDto addNewBookEntityDto);

    List<BookSummaryDTO> getAllBooksSummary();

    FullBookInfoDTO findFullBookInfoByBookId(Long id);
}
