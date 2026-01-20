package com.eazybytes.accounts.controllers;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.ResponceDto;
import com.eazybytes.accounts.dto.customerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {


    public ResponseEntity<ResponceDto> createAccount(@RequestBody customerDto customerDto ){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponceDto())
    }

}
