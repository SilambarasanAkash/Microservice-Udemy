package com.eazybytes.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Schema(
        name = "Responce detail",
        description = "Responce DTO hold all the responce detail"
)
public class ResponcesDTO {


    @Schema(
            description = "It send the Status code"
    )
    private String statusCode;

    @Schema(
            description = "Send the responce msg"
    )
    private String statusMsg;




}
