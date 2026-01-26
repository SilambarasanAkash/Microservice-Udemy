package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Schema(
        name = "Responce detail",
        description = "Responce DTO hold all the responce detail"
)
@Data
@AllArgsConstructor
public class ResponceDto {

    @Schema(
            description = "It send the Status code"
    )
    private String statusCode;

    @Schema(
            description = "Send the responce msg"
    )
    private String statusMsg;

}
