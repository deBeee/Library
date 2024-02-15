package library.controllers;

import jakarta.annotation.Resource;
import library.dao.IBookDAO;
import library.service.IBookService;
import library.session.SessionObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CommonController {

    private final IBookService bookService;

    @Resource
    SessionObject sessionObject;

    @GetMapping(path = {"/", "/main", "/index"})
    public String mainPage(Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("books", this.bookService.getAll());
        return "main";
    }

    @PostMapping(path = "/main")
    public String mainPage(@RequestParam String userName,
                           @RequestParam String userSurname,
                           @RequestParam int bookId,
                           Model model) {
        this.sessionObject.setUserName(userName);
        this.sessionObject.setUserSurname(userSurname);
        model.addAttribute("bookId", bookId);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("books", this.bookService.getAll());
        return "main_borrow_book";
    }

}
