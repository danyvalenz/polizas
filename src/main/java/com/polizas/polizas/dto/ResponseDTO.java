package com.polizas.polizas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {

    @JsonProperty("Meta")
    private Meta meta;

    @JsonProperty("Data")
    private Object data;

}
