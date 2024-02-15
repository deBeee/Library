package library.dao;

import library.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {
    List<Book> getAll();

    void addAll(List<Book> books);

    Optional<Book> getById(int bookId);

    void persist(Book book);

    List<Book> getAllByPattern(String pattern);
}
