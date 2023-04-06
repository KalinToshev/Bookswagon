package com.softuni.bookswagon.web;

import com.softuni.bookswagon.model.dto.*;
import com.softuni.bookswagon.service.book.BookService;
import com.softuni.bookswagon.service.comment.CommentService;
import com.softuni.bookswagon.service.rate.RateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    private final CommentService commentService;

    private final RateService rateService;

    @Autowired
    public BookController(BookService bookService, CommentService commentService, RateService rateService) {
        this.bookService = bookService;
        this.commentService = commentService;
        this.rateService = rateService;
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

        List<ShowCommentDTO> comments = this.commentService.getAllCommentsForBook(id);

        List<ShowRateDTO> rates = this.rateService.getAllRatesForBook(id);

        model.addAttribute("fullBookInfoDTO", fullBookInfoDTO);

        model.addAttribute("comments", comments);

        model.addAttribute("rates", rates);

        return "book";
    }

    @GetMapping("/books/repo")
    public String getUserSavedBooks(Model model, Principal principal) {
        List<BookSummaryDTO> allSavedBooksOfUser = this.bookService.getAllSavedBooksOfUser(principal.getName());

        model.addAttribute("books", allSavedBooksOfUser);

        return "book-repo";
    }

    @PostMapping("/")
    public String addBookToUserBookRepo(@RequestParam("bookId") Long bookId, Principal principal) {
        this.bookService.addBookToUserRepo(bookId, principal.getName());

        return "redirect:/";
    }

    @PostMapping("/books/details/comment/add")
    private String addNewComment(@Valid AddCommentDTO addCommentDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addCommentDTO", addCommentDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addCommentDTO", bindingResult);
            return "redirect:/books/details/" + addCommentDTO.getBookId();
        }

        this.commentService.addComment(addCommentDTO);

        return "redirect:/books/details/" + addCommentDTO.getBookId();
    }

    @PostMapping("/books/details/rate/add")
    private String addNewRate(@Valid AddRateDTO addRateDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addRateDTO", addRateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRateDTO", bindingResult);
            return "redirect:/books/details/" + addRateDTO.getBookId();
        }

        this.rateService.addRate(addRateDTO);

        return "redirect:/books/details/" + addRateDTO.getBookId();
    }

    @ModelAttribute
    public AddNewBookEntityDto addNewBookEntityDto() {
        return new AddNewBookEntityDto();
    }

    @ModelAttribute
    public AddCommentDTO addCommentDTO() {return new AddCommentDTO();}

    @ModelAttribute
    public AddRateDTO addRateDTO() {return new AddRateDTO();}
}
