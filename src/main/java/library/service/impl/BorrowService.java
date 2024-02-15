package library.service.impl;

import jakarta.annotation.Resource;
import library.dao.IBookDAO;
import library.dao.IBorrowDAO;
import library.exceptions.BookNotFoundException;
import library.model.Book;
import library.model.Borrow;
import library.service.IBorrowService;
import library.session.SessionObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BorrowService implements IBorrowService {

    private final IBorrowDAO borrowDAO;
    private final IBookDAO bookDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void borrowBook(int bookId) {
        Book borrowedBook = this.bookDAO.getById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with id=%d not found".formatted(bookId)));
        borrowedBook.setQuantity(borrowedBook.getQuantity() - 1);
        Borrow borrowToSave = Borrow.builder()
                .book(borrowedBook)
                .borrowDate(LocalDate.now())
                .isReturned(false)
                .user(this.sessionObject.getLoggedUser())
                .borrowerName(this.sessionObject.getUserName())
                .borrowerSurname(this.sessionObject.getUserSurname())
                .build();
        this.borrowDAO.persist(borrowToSave);
    }

    @Override
    public List<Borrow> getAll() {
        return this.borrowDAO.getAll();
    }
}
