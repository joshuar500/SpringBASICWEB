package com.joshrincon.mvc.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// advising an exception from another method
@ControllerAdvice
public class DatabaseErrorHandler {

    // this will handle database exceptions and return the user
    // to an error.jsp instead of a list of code
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException ex) {
        return "error";
    }

}
