package com.softuni.bookswagon.web;

import com.softuni.bookswagon.model.dto.AddNewBookEntityDto;
import com.softuni.bookswagon.model.dto.FullBookInfoDTO;
import com.softuni.bookswagon.service.book.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/add")
    public String getAddBookPage() {
        return "add-book";
    }

    @PostMapping("/books/add")
    public String addNewBook(@Valid AddNewBookEntityDto addNewBookEntityDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addNewBookEntityDto", addNewBookEntityDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addNewBookEntityDto", bindingResult);
            return "redirect:/books/add";
        }

        this.bookService.addBook(addNewBookEntityDto);

        return "redirect:/";
    }

    @GetMapping("/books/details/{id}")
    public String getFullBookDetails(@PathVariable("id") Long id, Model model) {
        FullBookInfoDTO fullBookInfoDTO = this.bookService.findFullBookInfoByBookId(id);

        model.addAttribute("fullBookInfoDTO", fullBookInfoDTO);

        return "book";
    }

    @ModelAttribute
    public AddNewBookEntityDto addNewBookEntityDto() {
        return new AddNewBookEntityDto();
    }
}
