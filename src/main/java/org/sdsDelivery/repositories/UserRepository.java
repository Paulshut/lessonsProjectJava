package org.sdsDelivery.repositories;

import org.sdsDelivery.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> readUser();

    User createUser(User user);

    boolean DeleteUser(User user);

    User getUserById(Long id);

    User updateUser(User user);

    Optional<String> getLogin(String name);

    Optional<User> getUserByLogin(String login);
}