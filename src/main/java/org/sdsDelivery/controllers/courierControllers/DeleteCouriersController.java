package org.sdsDelivery.controllers.courierControllers;

import org.sdsDelivery.services.CourierService;
import org.sdsDelivery.services.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.COURIERS_DELETE;
import static org.sdsDelivery.utils.Constants.COURIERS_READ;

@WebServlet(urlPatterns = COURIERS_DELETE)
public class DeleteCouriersController extends HttpServlet {
    CourierService courierService = CourierServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        courierService.deleteCourier(courierService.getCourierById(id));
        req.getRequestDispatcher(COURIERS_READ).forward(req,resp);
    }
}