package com.eazybytes.accounts.exception;

import com.eazybytes.accounts.dto.ErrorResponceDto;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,String>validationErrors = new HashMap<>();

        List<ObjectError> allErrors=ex.getBindingResult().getAllErrors();

        allErrors.stream().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String fieldMsg = error.getDefaultMessage();
            validationErrors.put(fieldName,fieldMsg);
        });

        return new  ResponseEntity<>(validationErrors,HttpStatus.BAD_REQUEST);

    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponceDto> handleGlobalException(RuntimeException exception,WebRequest webRequest){

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
               new ErrorResponceDto(
                       webRequest.getDescription(false),
                       HttpStatus.INTERNAL_SERVER_ERROR,
                       exception.getMessage(),
                       LocalDateTime.now()
               )
       );

    }




    @ExceptionHandler(customerAlreadyExistException.class)
    public ResponseEntity<ErrorResponceDto> handleCustomerAlreadyExistException(customerAlreadyExistException exception, WebRequest webRequest){

        ErrorResponceDto errorResponceDto=new ErrorResponceDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponceDto.getErrorCode());
    }

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponceDto> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){

        ErrorResponceDto errorResponceDto= new ErrorResponceDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                resourceNotFoundException.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponceDto);


    }



}
