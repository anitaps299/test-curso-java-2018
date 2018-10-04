package com.at.test.curso.controller;

import com.at.test.curso.exception.NotFoundException;
import com.at.test.curso.model.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ControllerAdvice(basePackages = "com.at.test.curso.controller")
public class HandlerExceptionController {

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError serverError(IllegalArgumentException e) {
        return new ApiError(400, e.getClass().getSimpleName().concat(getExceptionMessage(e)));
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError notFound(NotFoundException e) {
        return new ApiError(404, e.getClass().getSimpleName().concat(getExceptionMessage(e)));
    }

    private String getExceptionMessage(Exception exception) {
        return Optional.ofNullable(exception)
                .map(Exception::getMessage)
                .orElse("");
    }
}
