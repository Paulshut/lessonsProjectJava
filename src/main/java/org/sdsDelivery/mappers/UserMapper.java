package org.sdsDelivery.mappers;

import org.sdsDelivery.entities.RoleUser;
import org.sdsDelivery.entities.User;
import javax.servlet.http.HttpServletRequest;
import static org.sdsDelivery.utils.Constants.*;

public class UserMapper {
    public User buildUser(HttpServletRequest request) {
        return User.builder()
                .name(request.getParameter(NAME_USER_PARAM))
                .surname(request.getParameter(SURNAME_USER_PARAM))
                .email(request.getParameter(EMAIL_USER_PARAM))
                .login(request.getParameter(LOGIN_USER_PARAM))
                .password(request.getParameter(PASSWORD_USER_PARAM))
                .roleUser(RoleUser.USER)
                .build();
    }
}