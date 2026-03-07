package com.eazybytes.accounts.controllers;

import com.eazybytes.accounts.Constants.AccountsConstant;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.ErrorResponceDto;
import com.eazybytes.accounts.dto.ResponceDto;
import com.eazybytes.accounts.dto.customerDto;
import com.eazybytes.accounts.exception.GlobalExceptionHandler;
import com.eazybytes.accounts.exception.customerAlreadyExistException;
import com.eazybytes.accounts.services.AccountsServiceImpl;
import com.eazybytes.accounts.services.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@Tag(
        name = "CRUD REST APIs For Eazy Bank",
        description = "CRUD REST APIs For Eazy Bank For Create,Read, Update,Delete Operations"
)
@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    IAccountsService IaccountsService;

    @Autowired
    GlobalExceptionHandler GlobalExceptionHandler;

    @Operation(
            summary = "Create the Account REST API",
            description = "REST API to create new user & accounts inside eazy back"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status Ok"
    )
    @PostMapping("/create-account")
    public ResponseEntity<ResponceDto> createAccount(@Valid @RequestBody customerDto customerDto ){
            IaccountsService.createAccount(customerDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponceDto(AccountsConstant.STATUS_201,AccountsConstant.MSG_201));
    }

    @Operation(
            summary = "Fetch the Account REST API",
            description = "REST API to Fetch  user & accounts inside eazybank"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Ok"
    )
    @GetMapping("/fetch")
    public ResponseEntity<customerDto> fetchCustomer(@RequestParam
                                                         @NotEmpty(message = "Email can not be  null value")
                                                         @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be 10")
                                                         String mobileNumber) throws Throwable {

        com.eazybytes.accounts.dto.customerDto customer =IaccountsService.fetchCustomer(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customer);
    }

    @Operation(
            summary = "Update the Account REST API",
            description = "REST API to Update user & accounts inside eazybank"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status Ok"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Update operation failed"


            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema =@Schema(
                                    implementation = ErrorResponceDto.class
                            )
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponceDto> updateAccounts(@Valid @RequestBody customerDto customerDto){
        boolean isUpdate=IaccountsService.updateAccount(customerDto);

        if(isUpdate){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponceDto(AccountsConstant.STATUS_201,"Account Updated Successfully"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponceDto(AccountsConstant.STATUS_417,AccountsConstant.MSG_417_UPDATE));
        }

    }


    @Operation(
            summary = "Delete the Account REST API",
            description = "REST API to Delete  user & accounts inside eazybank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponceDto.class
                            )
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponceDto> deleteAccount(@RequestParam
                                                         @NotEmpty(message = "Email can not be  null value")
                                                         @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be 10")
                                                         String mobileNumber){
        boolean isDelete=IaccountsService.deleteAccount(mobileNumber);

        if(isDelete){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponceDto(AccountsConstant.STATUS_200,AccountsConstant.MSG_200));
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponceDto(AccountsConstant.STATUS_417,AccountsConstant.MSG_417_DELETE));
    }


}
