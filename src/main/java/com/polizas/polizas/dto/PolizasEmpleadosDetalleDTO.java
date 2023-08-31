package com.polizas.polizas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PolizasEmpleadosDetalleDTO {

        @JsonProperty("Poliza")
        private PolizaDTO Poliza;

        @JsonProperty("Empleado")
        private EmpleadoDTO Empleado;

        @JsonProperty("DetalleArticulo")
        private DetalleArticuloDTO DetalleArticulo;
}
