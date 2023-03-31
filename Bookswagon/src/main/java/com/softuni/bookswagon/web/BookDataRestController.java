package com.softuni.bookswagon.web;

import com.softuni.bookswagon.model.dto.BookSummaryDTO;
import com.softuni.bookswagon.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookDataRestController {
    private final BookService bookService;

    @Autowired
    public BookDataRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookSummaryDTO>> getAllBookSummary() {
        return ResponseEntity.ok(this.bookService.getAllBooksSummary());
    }
}
