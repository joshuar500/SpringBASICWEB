package com.joshrincon.mvc.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// advising an exception from another method
@ControllerAdvice
public class ErrorHandler {

    // this will handle database exceptions and return the user
    // to an error.jsp instead of a list of code
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException ex) {
        ex.printStackTrace();
        return "error";
    }

    // this fixes the weird bug that redirects
    // to a login to a page that NOBODY can have
    // access to
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex) {
        return "denied";
    }


}
