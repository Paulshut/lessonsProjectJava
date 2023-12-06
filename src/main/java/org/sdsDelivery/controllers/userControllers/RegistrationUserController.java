package org.sdsDelivery.controllers.userControllers;

import org.sdsDelivery.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.USERS_REGISTRATION;
import static org.sdsDelivery.utils.Constants.USERS_REGISTRATION_PAGE;

@WebServlet(urlPatterns = USERS_REGISTRATION)
public class RegistrationUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(USERS_REGISTRATION_PAGE).forward(req,resp);
    }
}