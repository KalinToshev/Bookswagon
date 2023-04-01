package com.softuni.bookswagon.web;

import com.softuni.bookswagon.service.book.BookService;
import com.softuni.bookswagon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private final UserService userService;

    private final BookService bookService;

    @Autowired
    public AdminController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/administrator/panel")
    public String getAdministratorPanelPage(Model model) {
        model.addAttribute("users", this.userService.findAllUsersAndMapForAdminPanel());
        model.addAttribute("books", this.bookService.findAllBooksAndMapForAdminPanel());
        return "admin-panel";
    }

    @PostMapping("/administrator/user/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        this.userService.deleteById(id);
        return "redirect:/administrator/panel";
    }

    @PostMapping("/administrator/book/delete")
    public String deleteBook(@RequestParam("id") Long id) {
        this.bookService.deleteById(id);
        return "redirect:/administrator/panel";
    }
}
