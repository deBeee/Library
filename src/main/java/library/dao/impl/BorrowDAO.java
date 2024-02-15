package library.dao.impl;

import jakarta.annotation.Resource;
import library.dao.IBorrowDAO;
import library.model.Borrow;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BorrowDAO implements IBorrowDAO {

    SessionFactory sessionFactory;
    @Override
    public void persist(Borrow borrow) {
        Session session = this.sessionFactory.openSession();
        borrow.setBook(session.merge(borrow.getBook()));
        try {
            session.beginTransaction();
            session.persist(borrow);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Borrow> getAll() {
        Session session = this.sessionFactory.openSession();
        Query<Borrow> query = session.createQuery("FROM library.model.Borrow", Borrow.class);
        List<Borrow> result = query.getResultList();
        session.close();
        return result;
    }
}
