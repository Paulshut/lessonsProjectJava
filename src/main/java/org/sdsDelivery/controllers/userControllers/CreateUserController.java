package org.sdsDelivery.controllers.userControllers;

import org.sdsDelivery.mappers.UserMapper;
import org.sdsDelivery.entities.User;
import org.sdsDelivery.services.UserService;
import org.sdsDelivery.services.UserServiceImpl;
import org.sdsDelivery.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.*;
import static org.sdsDelivery.utils.Constants.USERS_CREATE;
import static org.sdsDelivery.utils.Constants.USERS_CREATE_PAGE;

@WebServlet(urlPatterns = USERS_CREATE)
public class CreateUserController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    private final UserMapper userMapper = new UserMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(USERS_CREATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userMapper.buildUser(req);
        userService.createUser(user);
        req.getRequestDispatcher(USERS_MENU).forward(req, resp);
    }
}