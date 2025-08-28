package com.bs0842.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Response", description = "Schema to hold successful response information")
public class ResponseDto {

    private String statusCode;

    private String statusMsg;
}
