package com.dracarys.springdatajpa.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason =  "Something error")
class CustomException extends RuntimeException {

    HttpStatus status;
    String msg;

    public CustomException( HttpStatus status,String message) {
        super(message);
        this.msg = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}