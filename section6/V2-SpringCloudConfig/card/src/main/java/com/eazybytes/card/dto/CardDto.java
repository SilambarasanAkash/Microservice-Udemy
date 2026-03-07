package com.eazybytes.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Schema(
        name = "Card",
        description = "This JSON have card details"
)
public class CardDto {

    @Schema(
            name = "mobileNumber",
            example = "9437243823"
    )
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @Schema(
            name = "cardnumber"
    )
    @NotEmpty(message = "Card Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "CardNumber must be 12 digits")
    private String cardNumber;

    @Schema(
            name = "cardtype",
            example = "Debit card"
    )
    @NotEmpty(message = "CardType can not be a null or empty")
    private String cardType;

    @Schema(
            name = "Total limit"
    )
    @Positive(message = "Total card limit should be greater than zero")
    private int totalLimit;

    @Schema(
            name = "Amount Used"
    )
    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    private int amountUsed;

    @Schema(
            name = "Available Amount"
    )
    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;

}
