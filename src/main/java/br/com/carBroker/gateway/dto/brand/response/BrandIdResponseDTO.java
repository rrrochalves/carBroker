package br.com.carBroker.gateway.dto.brand.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record BrandIdResponseDTO(
        @Schema(description = "Id da marca")
        Integer id) {
}
