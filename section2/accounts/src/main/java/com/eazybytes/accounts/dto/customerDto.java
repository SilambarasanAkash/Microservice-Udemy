package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account info"
)
public class customerDto {


    @Schema(
            description = "Name of the customer",
            example = "EazyBank"
    )
    @NotEmpty(message = "Name can not be  null value")
    @Size(min = 4 , max = 20 ,message = "Name Should be 4 digit must")
    private String name;


    @Schema(
            description = "Email of the customer",
            example = "eazybank@gmail.com"
    )
    @NotEmpty(message = "Email can not be  null value")
    @Email(message = "Email is not valid kindly check")
    private String email;

    @Schema(
            description = "MobileNumber of the customer",
            example = "+91 0123456789"
    )
    @NotEmpty(message = "Mobile can not be  null value")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be 10")
    private String mobileNumber;

    @Schema(
            description = "accounts details of the Customer"
    )
    private AccountsDto accounts;
}
