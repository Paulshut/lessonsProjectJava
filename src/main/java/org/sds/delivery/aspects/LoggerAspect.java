package org.sds.delivery.aspects;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
    private static final String LOG_REQUEST_PATTERN = "{} -> {}: {} - {}";
    private static final String LOG_RESPONSE_PATTERN = "{} -> {}: {}, response: {}";
    private static final String LOG_EXCEPTION_PATTERN = "{} -> {}: {}, exception: {}";

    @Pointcut("execution(* org.sds.delivery.controllers..*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logRequest(JoinPoint joinPoint) {
        HttpServletRequest request = getRequest();
        log.info(LOG_REQUEST_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                joinPoint.getArgs());
    }

    @AfterReturning(value = "pointCut()", returning = "response")
    public void logResponse(JoinPoint joinPoint, Object response) {
        HttpServletRequest request = getRequest();
        log.info(LOG_RESPONSE_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                response);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        HttpServletRequest request = getRequest();
        log.warn(LOG_EXCEPTION_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                exception.toString());
    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}