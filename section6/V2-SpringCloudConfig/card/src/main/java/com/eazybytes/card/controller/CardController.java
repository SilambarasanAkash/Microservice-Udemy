package com.eazybytes.card.controller;

import com.eazybytes.card.Constants.CardsConstants;
import com.eazybytes.card.dto.CardDto;
import com.eazybytes.card.dto.CardsContactDetailsDto;
import com.eazybytes.card.dto.ErrorResponcesDTO;
import com.eazybytes.card.dto.ResponcesDTO;
import com.eazybytes.card.entity.Cards;
import com.eazybytes.card.mapper.CardsMapper;
import com.eazybytes.card.service.IcardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/card",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(
        name = "CARD SERVICE APIs",
        description = "All the Card related Apis details is there in below."
)
public class CardController {

    IcardService icardService;

    CardsContactDetailsDto cardsContactDetailsDto;


    @Operation(
            summary = "Create the Card REST API",
            description =  "Create the Card For Eazy Bank Users"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Ok"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponcesDTO>createCard(@RequestParam String mobileNumber){
        icardService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponcesDTO(CardsConstants.STATUS_201,CardsConstants.MSG_201));
    }


    @Operation(
            summary = "Fetch the Card REST API",
            description =  "Fetch the Card Details For Eazy Bank Users"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Ok"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCard(@RequestParam String mobileNumber){
       com.eazybytes.card.entity.Cards cards = icardService.fetchCard(mobileNumber);
       return ResponseEntity.status(HttpStatus.OK).body(CardsMapper.mapToCardDto(new CardDto() , cards));
    }


    @Operation(
            summary = "Update the Card REST API",
            description =  "Update the Card Details For Eazy Bank Users"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
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
                            schema = @Schema(
                                    implementation = ErrorResponcesDTO.class
                            )
                    )
            )
        }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponcesDTO>updateCardDetails(@RequestBody CardDto cardDto){
       boolean isUpdate= icardService.updateCard(cardDto);

       if(isUpdate){
           return ResponseEntity.status(HttpStatus.OK)
                   .body(new ResponcesDTO(CardsConstants.STATUS_200,CardsConstants.MSG_200));
       }else {
           return  ResponseEntity.status(HttpStatus.OK)
                   .body(new ResponcesDTO(CardsConstants.STATUS_417,CardsConstants.MSG_417_UPDATE));
       }


    }

    @Operation(
            summary = "Delete the Card REST API",
            description =  "Delete the Card Details For Eazy Bank Users"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status Ok"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Delete operation failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponcesDTO.class
                            )
                    )
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponcesDTO>deleteCard(@RequestParam String mobileNumber){
        boolean isDelete=icardService.deleteCard(mobileNumber);

        if (isDelete){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponcesDTO(
                    CardsConstants.STATUS_200,CardsConstants.MSG_200
            ));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponcesDTO(
                    CardsConstants.STATUS_417,CardsConstants.MSG_417_DELETE
            ));
        }

    }




    @Operation(
            summary = "Update the Card REST API",
            description =  "Update the Card Details For Eazy Bank Users"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
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
                            schema = @Schema(
                                    implementation = ErrorResponcesDTO.class
                            )
                    )
            )
    }
    )
    @GetMapping("/get-cards-details")
    public ResponseEntity<CardsContactDetailsDto> getCardsContactDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(cardsContactDetailsDto);
    }





}
