package com.eazybytes.accounts.exception;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@AllArgsConstructor
public class customerAlreadyExistException extends RuntimeException {


    public customerAlreadyExistException(String errorMsg){
        super(errorMsg);
    }



}
