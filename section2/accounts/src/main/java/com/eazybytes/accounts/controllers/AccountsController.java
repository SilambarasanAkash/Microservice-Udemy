package com.eazybytes.accounts.controllers;

import com.eazybytes.accounts.Constants.AccountsConstant;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.ResponceDto;
import com.eazybytes.accounts.dto.customerDto;
import com.eazybytes.accounts.exception.GlobalExceptionHandler;
import com.eazybytes.accounts.exception.customerAlreadyExistException;
import com.eazybytes.accounts.services.AccountsServiceImpl;
import com.eazybytes.accounts.services.IAccountsService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    @Autowired
    IAccountsService IaccountsService;

    @Autowired
    GlobalExceptionHandler GlobalExceptionHandler;


    public ResponseEntity<ResponceDto> createAccount(@RequestBody customerDto customerDto ){
            IaccountsService.createAccount(customerDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponceDto(AccountsConstant.STATUS_201,AccountsConstant.MSG_201));
    }

}
