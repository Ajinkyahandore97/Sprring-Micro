package com.zoo.exptions;

import com.zoo.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponse>handleResoursNotFoundException(ResourseNotFoundException ex)
    {

        String message = ex.getMessage();
        ApiResponse build = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return  new ResponseEntity<ApiResponse>(build,HttpStatus.NOT_FOUND);
    }
}
