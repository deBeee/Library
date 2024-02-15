package library.dao;

import library.model.User;

import java.util.Optional;

public interface IUserDAO {
    void persist(User user);

    Optional<User> getByLogin(String login);
}
