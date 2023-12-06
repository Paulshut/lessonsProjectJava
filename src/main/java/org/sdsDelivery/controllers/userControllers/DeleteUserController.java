package org.sdsDelivery.controllers.userControllers;

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

@WebServlet(urlPatterns = USERS_DELETE)
public class DeleteUserController extends HttpServlet {
    private final static UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter(ID_USER_PARAM));
        userService.deleteUser(userService.getUserById(id));
        req.getRequestDispatcher(USERS_READ).forward(req, resp);
    }
}