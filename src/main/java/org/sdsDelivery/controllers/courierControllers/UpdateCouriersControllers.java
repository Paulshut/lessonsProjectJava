package org.sdsDelivery.controllers.courierControllers;

import org.sdsDelivery.entities.Courier;
import org.sdsDelivery.services.CourierService;
import org.sdsDelivery.services.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.*;

@WebServlet(urlPatterns = COURIERS_UPDATE)
public class UpdateCouriersControllers extends HttpServlet {
    CourierService courierService = CourierServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(COURIERS_UPDATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courierService.updateCourier(req);
        req.getRequestDispatcher(COURIERS_READ).forward(req, resp);
    }
}