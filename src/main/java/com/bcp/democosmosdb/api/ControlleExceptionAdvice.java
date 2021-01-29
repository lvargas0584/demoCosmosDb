package com.bcp.democosmosdb.api;

import com.azure.cosmos.implementation.NotFoundException;
import com.bcp.democosmosdb.core.dto.ErrorResponse;
import com.bcp.democosmosdb.core.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControlleExceptionAdvice {

    @ExceptionHandler(value = StudentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse error(StudentNotFoundException ex) {
        return new ErrorResponse(1, ex.getMessage());
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse error(NotFoundException ex) {
        return new ErrorResponse(2, ex.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse error(RuntimeException ex) {
        return new ErrorResponse(3, "ERROR EN SISTEMA");
    }


    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse error(NumberFormatException ex) {
        return new ErrorResponse(3, "ERROR EN SISTEMA");
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse error(Exception ex) {
        return new ErrorResponse(3, ex.getMessage());
    }

}
