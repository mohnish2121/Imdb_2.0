package com.greytip.imdb.controller;

import com.greytip.imdb.model.HelloWorldResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/movies")
public class HelloWorldController {

    @GetMapping
    @ApiOperation(value = "get string to be printed",
        notes = "this api returns string as data to be printed",
        response = HelloWorldResponse.class)
    public ResponseEntity<HelloWorldResponse> helloWorld() {

        String input = "Hello World";
        return new ResponseEntity<HelloWorldResponse>( new HelloWorldResponse(input), HttpStatus.OK );
    }
}
