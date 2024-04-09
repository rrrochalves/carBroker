package br.com.carBroker.gateway.dto.vehicle.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record VehicleIdResponseDTO(
        @Schema(description = "Id do veiculo criado")
        Integer id) {
}
