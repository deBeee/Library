package library.controllers;

import jakarta.annotation.Resource;
import library.dao.IBookDAO;
import library.model.Borrow;
import library.service.IBookService;
import library.service.IBorrowService;
import library.session.SessionObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class BorrowController {

    IBorrowService borrowService;
    IBookService bookService;

    @Resource
    SessionObject sessionObject;

    @GetMapping(path = "/book/add/{bookId}")
    public String borrowBook(@PathVariable final int bookId) {
        this.borrowService.borrowBook(bookId);
        return "redirect:/main";
    }

    @GetMapping(path = "/book/borrow/{bookId}")
    public String getBookBorrowerInfo(@PathVariable final int bookId, Model model) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("books",this.bookService.getAll());
        model.addAttribute("isLogged",this.sessionObject.isLogged());
        model.addAttribute("borrowModel", new Borrow());
        return "main_borrow_book";
    }

    @GetMapping(path = "/books/borrowed")
    public String displayBorrowedBooks(Model model){
        List<Borrow> allBorrows = this.borrowService.getAll();
        model.addAttribute("borrows", allBorrows);
        model.addAttribute("isLogged",this.sessionObject.isLogged());
        return "borrowed_books_page";
    }
}
