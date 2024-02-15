package library.service;

import library.model.Book;

import java.util.List;

public interface IBookService {
    void add(Book book);

    List<Book> getAll();

    List<Book> getAllByPattern(String pattern);
}
