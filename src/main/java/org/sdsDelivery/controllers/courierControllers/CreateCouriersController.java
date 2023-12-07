package org.sdsDelivery.controllers.courierControllers;

import org.sdsDelivery.entities.Courier;
import org.sdsDelivery.mappers.CourierMapper;
import org.sdsDelivery.services.CourierService;
import org.sdsDelivery.services.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.*;

@WebServlet(urlPatterns = COURIERS_CREATE)
public class CreateCouriersController extends HttpServlet {
    CourierService courierService = CourierServiceImpl.getInstance();
    CourierMapper courierMapper = new CourierMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(COURIERS_CREATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Courier courier = courierMapper.builderCourier(req);
        courierService.createCourier(courier);
        req.getRequestDispatcher(COURIERS_READ).forward(req, resp);
    }
}