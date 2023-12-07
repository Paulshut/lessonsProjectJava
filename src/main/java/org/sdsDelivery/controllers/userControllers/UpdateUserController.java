package org.sdsDelivery.controllers.userControllers;

import org.sdsDelivery.entities.User;
import org.sdsDelivery.mappers.UserMapper;
import org.sdsDelivery.services.UserService;
import org.sdsDelivery.services.UserServiceImpl;
import org.sdsDelivery.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.*;

@WebServlet(urlPatterns = USERS_UPDATE)
public class UpdateUserController extends HttpServlet {
    private final static UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(USERS_UPDATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.updateUser(req);
        req.getRequestDispatcher(USERS_READ).forward(req, resp);
    }
}