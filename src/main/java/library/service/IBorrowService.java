package library.service;

import library.model.Borrow;

import java.util.List;

public interface IBorrowService {

    void borrowBook(int bookId);

    List<Borrow> getAll();
}
