package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Accounts details for that customer"
)
public class AccountsDto {


    @Schema(
            description = "Schema to hold AccountNumber for the customer",
            example = "3467293831"
    )
    @NotEmpty(message = "AccountNumber Can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account Number should be 10 Charater")
    private long accountNumber;

    @Schema(
            description = "Schema to hold AccountType"
    )
    @NotEmpty(message = "AccountType Can not be a null or empty")
    private String accountType;

    @Schema(
            description = "Schema to hold BranchAddress",
            example = "123 chennai"
    )
    @NotEmpty(message = "BranchAddress Can not be a null or empty")
    private String branchAddress;

}
