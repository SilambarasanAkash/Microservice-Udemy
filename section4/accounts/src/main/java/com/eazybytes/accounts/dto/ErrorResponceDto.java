package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponces",
        description = "Schema to hold Error Responce Info"
)
@Data @AllArgsConstructor
public class ErrorResponceDto {

    @Schema(
            description = "API Path Invoked by client"
    )
    private String apiPath;

    @Schema(
            description = "Errorcode detail"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "API Path Error Msg Details"
    )
    private String errorMsg;

    @Schema(
            description = "API Path Error Time Details"
    )
    private LocalDateTime errorTime;
}
