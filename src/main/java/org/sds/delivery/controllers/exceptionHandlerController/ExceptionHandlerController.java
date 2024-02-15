package org.sds.delivery.controllers.exceptionHandlerController;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sds.delivery.dto.responses.userResponse.ErrorResponse;
import org.sds.delivery.exceptions.OrderNotFoundException;
import org.sds.delivery.exceptions.UserNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ResponseStatus(BAD_REQUEST)
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {
    public final MessageSource messageSource;
    private static final String USER_NOT_FOUND_MESSAGE_KEY = "user.missing.message";
    private static final String ORDER_NOT_FOUND_MESSAGE_KEY = "order.missing.message";
    private static final String DEFAULT_MESSAGE_KEY = "exception.default.message";

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleUserNotFoundException(EntityNotFoundException exception) {
        return ErrorResponse.builder()
                .message(getMessage(exception))
                .build();
    }

    private String getMessage(EntityNotFoundException exception) {
        if (exception instanceof UserNotFoundException) {
            return messageSource.getMessage(USER_NOT_FOUND_MESSAGE_KEY,
                    new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
        } else if (exception instanceof OrderNotFoundException) {
            return messageSource.getMessage(ORDER_NOT_FOUND_MESSAGE_KEY,
                    new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
        } else
            return messageSource.getMessage(DEFAULT_MESSAGE_KEY,
                    new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
    }
}