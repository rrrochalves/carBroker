package br.com.carBroker.gateway.dto.vehicle.request;

import br.com.carBroker.domain.enums.Fuel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequestDTO {

    @Schema(description = "Ano do veiculo")
    @NotNull(message = "O ano do veículo é obrigatório!")
    private Integer year;

    @Schema(description = "Combustivel do veiculo")
    @NotNull(message = "O combustivel do veículo é obrigatório!")
    private Fuel fuel;

    @Schema(description = "Numero de portas do veiculo")
    @NotNull(message = "O numero de portas do veículo é obrigatório!")
    private Integer numberOfDoors;

    @Schema(description = "Cor do veiculo")
    @NotBlank(message = "A cor do veiculo é obrigatória")
    private String color;

    @Schema(description = "Id do modelo do veiculo")
    @NotNull(message = "O modelo do veiculo é obrigatório!")
    private Integer vehicleModelId;
}
