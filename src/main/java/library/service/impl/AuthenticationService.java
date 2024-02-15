package library.service.impl;

import jakarta.annotation.Resource;
import library.dao.IUserDAO;
import library.model.User;
import library.service.IAuthenticationService;
import library.session.SessionObject;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService implements IAuthenticationService {

    private final IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;
    @Override
    public void register(User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.persist(user);
    }

    @Override
    public void login(User user) {
        Optional<User> userBox = this.userDAO.getByLogin(user.getLogin());
        if(userBox.isPresent() &&
                userBox.get().getPassword().equals(DigestUtils.md5Hex(user.getPassword()))) {
            this.sessionObject.setLoggedUser(userBox.get());
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }
}
