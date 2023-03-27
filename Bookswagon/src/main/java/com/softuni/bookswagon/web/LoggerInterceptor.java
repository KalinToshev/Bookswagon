package com.softuni.bookswagon.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class LoggerInterceptor implements HandlerInterceptor {
    // Create a logger instance for this class
    private static final Logger logger = Logger.getLogger(LoggerInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Get the requested URI from the request object
        String requestURI = request.getRequestURI();

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Create a formatter for the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");

        // Format the date and time using the formatter
        String formattedDateTime = now.format(formatter);

        // Log the formatted date and time and requested URI to the console using the logger
        logger.info("CUSTOM LOG: " + formattedDateTime + " - " + requestURI);

        // Return true to allow the request to be processed by the controller
        return true;
    }
}
