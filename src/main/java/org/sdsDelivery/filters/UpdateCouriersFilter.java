package org.sdsDelivery.filters;

import org.sdsDelivery.entities.RoleUser;
import org.sdsDelivery.utils.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.sdsDelivery.utils.Constants.*;

@WebFilter(urlPatterns = COURIERS_UPDATE)
public class UpdateCouriersFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        RoleUser roleUser = (RoleUser) session.getAttribute(ROLE_USER_PARAM);
        if (roleUser == RoleUser.ADMIN) {
            req.getRequestDispatcher(COURIERS_UPDATE).forward(req, res);
        } else {
            req.getRequestDispatcher(COURIERS_ERROR_PAGE).forward(req, res);
        }
    }
}