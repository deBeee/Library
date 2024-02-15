package library.session;

import library.model.Borrow;
import library.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component
@SessionScope
@Getter
@Setter
public class SessionObject {

    private User loggedUser;

    private String userName;
    private String userSurname;

    public boolean isLogged(){
        return loggedUser != null;
    }


}
