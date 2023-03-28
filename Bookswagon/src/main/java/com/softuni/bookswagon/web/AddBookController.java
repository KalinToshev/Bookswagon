package com.softuni.bookswagon.web;

import com.softuni.bookswagon.model.dto.AddNewBookEntityDto;
import com.softuni.bookswagon.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books/add")
public class AddBookController {
    private final BookService bookService;

    @Autowired
    public AddBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAddBookPage() {
        return "add-book";
    }

    @PostMapping
    public String addNewBook(AddNewBookEntityDto addNewBookEntityDto) {
        this.bookService.addBook(addNewBookEntityDto);

        return "redirect:/";
    }

    @ModelAttribute
    public AddNewBookEntityDto addNewBookEntityDto() {
        return new AddNewBookEntityDto();
    }
}
