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
import java.util.List;

import static org.sdsDelivery.utils.Constants.COURIERS_READ;
import static org.sdsDelivery.utils.Constants.COURIERS_READ_PAGE;

@WebServlet(urlPatterns = COURIERS_READ)
public class ReadCouriersController extends HttpServlet {
    CourierService courierService = CourierServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Courier> couriers = courierService.readCouriers();
        req.setAttribute("couriers", couriers);
        req.getRequestDispatcher(COURIERS_READ_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}