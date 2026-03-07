package com.eazybytes.card.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@AllArgsConstructor
public class AlreadyExistExceptionHandler extends RuntimeException{


    public AlreadyExistExceptionHandler(String msg){
        super(msg);
    }


}
