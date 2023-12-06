package org.sdsDelivery.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    /**
     * Users params
     */
    public static final String NAME_USER_PARAM = "name";
    public static final String SURNAME_USER_PARAM = "surname";
    public static final String EMAIL_USER_PARAM = "email";
    public static final String LOGIN_USER_PARAM = "login";
    public static final String PASSWORD_USER_PARAM = "password";
    public static final String ID_USER_PARAM = "id";
    public static final String ROLE_USER_PARAM = "roleUser";

    /**
     * Users pages
     */
    public static final String USERS_READ_PAGE = "/pages/users/readUsers.jsp";
    public static final String USERS_CREATE_PAGE = "/pages/users/createUsers.jsp";
    public static final String USERS_UPDATE_PAGE = "/pages/users/updateUsers.jsp";
    public static final String USERS_MENU_PAGE = "/pages/users/menuUsers.jsp";
    public static final String USERS_REGISTRATION_PAGE = "/pages/users/registrationUsers.jsp";
    public static final String USERS_AUTHENTICATION_ERROR_PAGE = "/pages/errors/authenticationError.jsp";
    public static final String USERS_ERROR_PAGE = "/pages/errors/usersError.jsp";
    public static final String USERS_REG_ERROR_PAGE = "/pages/errors/registrationError.jsp";

    /**
     * Users servlets
     */
    public static final String USERS_MENU = "/users/menu";
    public static final String USERS_DATA = "/users/dataUsers";
    public static final String USERS_CREATE = "/users/create";
    public static final String USERS_DELETE = "/users/delete";
    public static final String USERS_READ = "/users/read";
    public static final String USERS_UPDATE = "/users/update";
    public static final String USERS_REGISTRATION = "/users/registration";
    public static final String USERS_AUTHENTICATION = "/users/authentication";



    /**
     * Couriers params
     */
    public static final String ID_COURIERS_PARAM = "id";
    public static final String NAME_COURIERS_PARAM = "name";
    public static final String SURNAME_COURIERS_PARAM = "surname";
    public static final String PHONE_COURIERS_PARAM = "contactPhone";

    /**
     * Couriers servlets
     */
    public static final String COURIERS_CREATE = "/couriers/create";
    public static final String COURIERS_DELETE = "/couriers/delete";
    public static final String COURIERS_READ = "/couriers/read";
    public static final String COURIERS_UPDATE = "/couriers/update";

    /**
     * Couriers pages
     */
    public static final String COURIERS_CREATE_PAGE = "/pages/couriers/createCourier.jsp";
    public static final String COURIERS_UPDATE_PAGE = "/pages/couriers/updateCourier.jsp";
    public static final String COURIERS_READ_PAGE = "/pages/couriers/readCourier.jsp";
    public static final String COURIERS_ERROR_PAGE = "/pages/errors/couriersError.jsp";

    /**
     * Couriers pages
     */
    public static final String PARCELS_CREATE_PAGE = "/pages/parcels/createParcels.jsp";
}