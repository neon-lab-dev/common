package com.neonlab.common.expectations;

import com.neonlab.common.dto.ApiOutput;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = InvalidInputException.class)
    public ApiOutput<?> handleInvalidInputs(InvalidInputException ex, WebRequest request){
        return new ApiOutput<String>(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

}
