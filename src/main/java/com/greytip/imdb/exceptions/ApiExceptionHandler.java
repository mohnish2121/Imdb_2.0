package com.greytip.imdb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler( value = { ApiRequestException.class })
    public ResponseEntity<Object> handleApiRequest( ApiRequestException e ) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        List<String> errorsDetails = new ArrayList<>();
        errorsDetails.add( e.getLocalizedMessage() );

        ApiException apiException = new ApiException(
                "Employee not found",
                errorsDetails,
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Asia/Kolkata"))
        );
        return new ResponseEntity<>( apiException, httpStatus );
    }

    @ExceptionHandler( value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handleArguementNotValid( MethodArgumentNotValidException e ) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errorsDetails = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach( error ->  {
            errorsDetails.add(error.getDefaultMessage());
        });

        ApiException apiException = new ApiException(
                "Validation failed",
                errorsDetails,
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Asia/Kolkata"))
        );

        return new ResponseEntity<>( apiException, httpStatus );

    }

}
