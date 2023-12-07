package org.sdsDelivery.controllers.parcelsControllers;

import org.sdsDelivery.entities.Parcel;
import org.sdsDelivery.mappers.ParcelMapper;
import org.sdsDelivery.services.ParcelService;
import org.sdsDelivery.services.ParcelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.PARCELS_CREATE_PAGE;

@WebServlet(urlPatterns = "/parcels/create")
public class createParcelsController extends HttpServlet {
    private final ParcelService parcelService = ParcelServiceImpl.getInstance();
    private final ParcelMapper parcelMapper = new ParcelMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PARCELS_CREATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Parcel parcel = parcelMapper.buildParcel(req);
        parcelService.createParcel(parcel);
        req.getRequestDispatcher("/pages/parcels/createParcels.jsp").forward(req,resp);
    }
}
