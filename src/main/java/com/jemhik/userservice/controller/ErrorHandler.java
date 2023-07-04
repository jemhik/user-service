package com.jemhik.userservice.controller;

import com.jemhik.userservice.exeption.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Session;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;

@Slf4j
@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
    log.error("handleMethodArgumentNotValidException: message: {}", ex.getMessage(), ex);
    HttpSession session = request.getSession();
    session.setAttribute("message", ex.getMessage());
    return "error";
  }

  @ExceptionHandler(ServiceException.class)
  public String handleServiceException(ServiceException ex, HandlerMethod hm, HttpServletRequest request) {
    log.error("handleServiceException: message:{}, method: {}", ex.getMessage(), hm.getMethod().getName(), ex);
    HttpSession session = request.getSession();
    session.setAttribute("message", ex.getMessage());
    return "error";
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleException(Exception ex, HandlerMethod hm, HttpServletRequest request) {
    log.error("handleException: message: {}, method: {}", ex.getMessage(), hm.getMethod().getName(), ex);
    HttpSession session = request.getSession();
    session.setAttribute("message", ex.getMessage());
    return "error";
  }

}
