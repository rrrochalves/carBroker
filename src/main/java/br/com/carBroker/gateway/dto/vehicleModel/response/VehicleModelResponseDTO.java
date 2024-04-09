package br.com.carBroker.gateway.dto.vehicleModel.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleModelResponseDTO {

    @Schema(description = "Id do modelo do veículo")
    private Integer id;

    @Schema(description = "Nome do modelo do veículo")
    private String name;

    @Schema(description = "Valor da tabela fipe do veículo")
    private Double fipeValue;

    @Schema(description = "Id da marca")
    private Integer brandId;
}
