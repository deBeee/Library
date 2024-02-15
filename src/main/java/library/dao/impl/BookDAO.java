package library.dao.impl;

import jakarta.annotation.Resource;
import jakarta.persistence.NoResultException;
import library.dao.IBookDAO;
import library.model.Book;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BookDAO implements IBookDAO {
    private final String GET_BY_ID = "FROM library.model.Book WHERE id = :id";
    private final String GET_ALL = "FROM library.model.Book";
    private final String GET_BY_PATTERN =
            "FROM library.model.Book WHERE author like :pattern OR title like :pattern OR isbn like :pattern";

    SessionFactory sessionFactory;

    @Override
    public List<Book> getAll() {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery(GET_ALL, Book.class);
        List<Book> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void addAll(List<Book> books) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            for (Book book : books) {
                session.persist(book);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Book> getById(int id) {
        try (Session session = this.sessionFactory.openSession()) {
            Query<Book> query = session.createQuery(GET_BY_ID, Book.class);
            query.setParameter("id", id);
            try {
                return Optional.of(query.getSingleResult());
            } catch (NoResultException e) {
                return Optional.empty();
            }
        }
    }

    @Override
    public void persist(Book book) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> getAllByPattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery(GET_BY_PATTERN, Book.class);
        query.setParameter("pattern", "%" + pattern + "%");
        List<Book> result = query.getResultList();
        session.close();
        return result;
    }
}
