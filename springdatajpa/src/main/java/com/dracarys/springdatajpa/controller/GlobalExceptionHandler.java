package com.dracarys.springdatajpa.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {


//    @ExceptionHandler({CustomException.class, NullPointerException.class})
//    public Void handleException(HttpServletResponse response, Exception ex) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value(), "not bad from global  level");
//        return null;
//    }

//    @ExceptionHandler(RuntimeException.class)
//    public Void handleRuntimeException(HttpServletResponse response, RuntimeException ex) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value(), "not bad from global  runtime  level");
//        return null;
//    }
}
