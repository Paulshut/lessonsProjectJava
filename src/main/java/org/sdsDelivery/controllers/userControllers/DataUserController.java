package org.sdsDelivery.controllers.userControllers;

import org.sdsDelivery.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.USERS_CREATE_PAGE;
import static org.sdsDelivery.utils.Constants.USERS_DATA;

@WebServlet(USERS_DATA)
public class DataUserController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(USERS_CREATE_PAGE).forward(req, resp);
    }
}
