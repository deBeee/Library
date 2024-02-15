package library.controllers;

import jakarta.annotation.Resource;
import library.model.Book;
import library.service.IBookService;
import library.session.SessionObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {

    private final IBookService bookService;

    @Resource
    SessionObject sessionObject;

    @GetMapping(path = "/book/add")
    public String displayAddBookPage(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("isLogged",this.sessionObject.isLogged());
        return "add_book_page";
    }

    @PostMapping(path = "/book/add")
    public String displayAddBookPage(@ModelAttribute Book book){
        this.bookService.add(book);
        return "redirect:/main";
    }

    @GetMapping(path = "/book/search")
    public String displaySearchBookPage(Model model){
        model.addAttribute("isLogged",this.sessionObject.isLogged());
        model.addAttribute("books",this.bookService.getAll());
        return "search_book_page";
    }

    @PostMapping(path = "/book/search")
    public String displaySearchBookPage(@RequestParam String pattern, Model model){
        List<Book> allBooksByPattern = this.bookService.getAllByPattern(pattern);
        model.addAttribute("books", allBooksByPattern);
        model.addAttribute("isLogged",this.sessionObject.isLogged());
        return "search_book_page";
    }
}
