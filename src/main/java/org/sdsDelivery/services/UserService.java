package org.sdsDelivery.services;

import org.sdsDelivery.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> readUsers();
    User createUser(User user);

    boolean deleteUser(User user);

    User getUserById(Long id);

    User updateUser(HttpServletRequest request);

    Optional<String> getUserLogin(String userLogin);

    boolean checkUniqueLogin (Optional<String> userLogin);

    User getUserByLogin(String userLogin);

   boolean authenticationUsers (String login, String password);
}