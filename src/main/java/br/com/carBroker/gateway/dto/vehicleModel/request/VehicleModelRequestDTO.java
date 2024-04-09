package br.com.carBroker.gateway.dto.vehicleModel.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleModelRequestDTO {

    @NotBlank(message = "O nome do modelo é obrigatório!")
    @Schema(description = "Nome do modelo do veículo")
    private String name;

    @NotNull(message = "O valor da FIPE é obrigatório!")
    @Positive(message = "O valor tem que ser maior que zero!")
    @Schema(description = "Valor da tabela fipe do veículo")
    private Double fipeValue;

    @NotNull(message = "O id da marca é obrigatório!")
    @Schema(description = "id da marca")
    private Integer brandId;
}
