package org.sdsDelivery.repositories;

import org.sdsDelivery.entities.RoleUser;
import org.sdsDelivery.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepository userRepository;

    private final List<User> users = new ArrayList<>(getTestUser());


    @Override
    public List<User> readUser() {
        return users;
    }

    @Override
    public User createUser(User user) {
        user.setId((long) users.size() + 1);
        users.add(user);
        return user;
    }

    @Override
    public boolean DeleteUser(User user) {
        return users.remove(user);
    }

    @Override
    public User getUserById(Long id) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .get();
        return user;
    }

    @Override
    public User updateUser(User user) {
        return user;
    }

    @Override
    public Optional<String> getLogin(String login) {
        Optional<String> userLogin;
        userLogin = users.stream()
                .map(user -> user.getLogin())
                .filter(user -> user.equals(login))
                .findAny();
        return userLogin;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        Optional<User> optionalUser = users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
        return optionalUser;

    }

    List<User> getTestUser() {
        List<User> users = List.of(
                new User("Ivan",
                        "Ivanov",
                        "ivanov@test.ru",
                        1l,
                        "admin",
                        "admin",
                        RoleUser.ADMIN,
                        new ArrayList<>()),
                new User("Petr",
                        "Petrov",
                        "petrov@test.by",
                        2l,
                        "test",
                        "test",
                        RoleUser.USER,
                        new ArrayList<>()),
                new User("Vladimir",
                        "Kotov",
                        "kotov@test.by",
                        3l,
                        "kot",
                        "kot",
                        RoleUser.USER,
                        new ArrayList<>()));
        return users;
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }

    private UserRepositoryImpl() {
    }
}