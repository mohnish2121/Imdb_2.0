package com.greytip.imdb.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class ApiException {
    private final String message;
    private final List<String> details;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
