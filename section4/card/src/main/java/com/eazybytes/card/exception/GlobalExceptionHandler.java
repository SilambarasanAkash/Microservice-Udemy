package com.eazybytes.card.exception;

import com.eazybytes.card.dto.ErrorResponcesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(AlreadyExistExceptionHandler.class)
    public ResponseEntity<com.eazybytes.card.dto.ErrorResponcesDTO> AlreadyExistException(AlreadyExistExceptionHandler exceptionHandler, WebRequest webRequest){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponcesDTO(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exceptionHandler.getMessage(),
                LocalDateTime.now()
        ));

    }



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<com.eazybytes.card.dto.ErrorResponcesDTO> ResourseNotFoundException(ResourceNotFoundException exceptionHandler, WebRequest webRequest){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponcesDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exceptionHandler.getMessage(),
                LocalDateTime.now()
        ));

    }


}
