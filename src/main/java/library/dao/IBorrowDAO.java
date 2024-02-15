package library.dao;

import library.model.Borrow;

import java.util.List;

public interface IBorrowDAO {
    void persist(Borrow borrow);

    List<Borrow> getAll();
}
