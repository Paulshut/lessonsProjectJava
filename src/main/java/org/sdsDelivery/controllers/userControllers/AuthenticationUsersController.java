package org.sdsDelivery.controllers.userControllers;

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

@WebServlet(urlPatterns = USERS_AUTHENTICATION)
public class AuthenticationUsersController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_USER_PARAM);
        String password = req.getParameter(PASSWORD_USER_PARAM);
        if (userService.authenticationUsers(login, password)) {
            req.getRequestDispatcher(USERS_MENU_PAGE).forward(req, resp);
            HttpSession session = req.getSession(true);
            session.setAttribute("roleUser", userService.getUserByLogin(login).getRoleUser());
        } else {
            req.getRequestDispatcher(USERS_AUTHENTICATION_ERROR_PAGE).forward(req, resp);
        }
    }
}