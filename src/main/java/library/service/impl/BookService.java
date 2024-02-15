package library.service.impl;

import library.dao.IBookDAO;
import library.model.Book;
import library.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final IBookDAO bookDAO;
    @Override
    public void add(Book book) {
        this.bookDAO.persist(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookDAO.getAll();
    }

    @Override
    public List<Book> getAllByPattern(String pattern) {
        return this.bookDAO.getAllByPattern(pattern);
    }
}
