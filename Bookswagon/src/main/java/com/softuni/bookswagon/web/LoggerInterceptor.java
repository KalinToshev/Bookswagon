package com.softuni.bookswagon.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class LoggerInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(LoggerInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");

        String formattedDateTime = now.format(formatter);

        logger.info("CUSTOM LOG: " + formattedDateTime + " - " + requestURI);

        return true;
    }
}
