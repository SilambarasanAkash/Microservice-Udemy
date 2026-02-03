package com.eazybytes.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "Error Details")
public class ErrorResponcesDTO {

    @Schema(
            name = "ApiPath",
            description = "Error api path"
    )
    private String apiPath;

    @Schema(
            name = "HttpStatus",
            description = "Http Responce Status"
    )
    private HttpStatus httpStatus;

    @Schema(
            name = "ErrorMessage",
            description = "Error details shownSS"
    )
    private  String errorMsg;

    @Schema(
            name = "ErrorTime",
            description = "When Error would occur time"
    )
    private LocalDateTime errorTime;

}
