package library.service;

import library.model.User;

public interface IAuthenticationService {
    void register(User user);

    void login(User user);

    void logout();
}
