package org.sdsDelivery.services;

import org.sdsDelivery.entities.User;
import org.sdsDelivery.repositories.UserRepository;
import org.sdsDelivery.repositories.UserRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static org.sdsDelivery.utils.Constants.*;

public class UserServiceImpl implements UserService {
    private static UserService userService;
    private final UserRepository userRepository = UserRepositoryImpl.getInstance();

    @Override
    public List<User> readUsers() {
        return userRepository.readUser();
    }

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userRepository.DeleteUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User updateUser(HttpServletRequest request) {
       User user = userRepository.getUserById(Long.parseLong(request.getParameter(ID_USER_PARAM)));
       user.setName(request.getParameter(NAME_USER_PARAM));
       user.setSurname(request.getParameter(SURNAME_USER_PARAM));
       user.setEmail(request.getParameter(EMAIL_USER_PARAM));
       return user;
    }

    @Override
    public Optional<String> getUserLogin(String userLogin) {
        return userRepository.getLogin(userLogin);
    }

    @Override
    public boolean checkUniqueLogin(Optional<String> userLogin) {
        return userLogin.isPresent();
    }

    @Override
    public User getUserByLogin(String userLogin) {
       if (userRepository.getUserByLogin(userLogin).isPresent()){
        return userRepository.getUserByLogin(userLogin).get();
       }
       return null;
    }

    @Override
    public boolean authenticationUsers(String login, String password) {
      return  userRepository.getUserByLogin(login)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    private UserServiceImpl() {
    }
}