package org.sdsDelivery.filters;

import org.sdsDelivery.entities.User;
import org.sdsDelivery.services.UserService;
import org.sdsDelivery.services.UserServiceImpl;
import org.sdsDelivery.utils.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.*;
import static org.sdsDelivery.utils.Constants.USERS_CREATE_PAGE;

@WebFilter(urlPatterns = USERS_DATA)
public class LoginFilter extends HttpFilter {
    private final static UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String name = req.getParameter(LOGIN_USER_PARAM);
        if (userService.checkUniqueLogin(userService.getUserLogin(name))) {
            req.getRequestDispatcher( USERS_REG_ERROR_PAGE).forward(req, res);
        } else {
            req.getRequestDispatcher(USERS_CREATE_PAGE).forward(req, res);
        }
    }
}