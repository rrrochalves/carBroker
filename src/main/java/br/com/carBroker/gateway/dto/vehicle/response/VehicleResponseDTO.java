package br.com.carBroker.gateway.dto.vehicle.response;

import br.com.carBroker.domain.enums.Fuel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDTO {

    @Schema(description = "Id do veículo")
    private Integer id;

    @JsonProperty("timestamp_cadastro")
    @Schema(description = "Data de criação do veículo")
    private LocalDateTime createAt;

    @JsonProperty("modelo_id")
    @Schema(description = "Id do modelo do veículo")
    private Integer modelId;

    @JsonProperty("ano")
    @Schema(description = "Ano do veículo")
    private Integer year;

    @JsonProperty("combustivel")
    @Schema(description = "Combustível do veículo")
    private Fuel fuel;

    @JsonProperty("num_portas")
    @Schema(description = "Número de portas do veículo")
    private Integer numberOfDoors;

    @JsonProperty("cor")
    @Schema(description = "Cor do veículo")
    private String color;

    @JsonProperty("nome_modelo")
    @Schema(description = "Nome do modelo do veículo")
    private String modelName;

    @JsonProperty("valor")
    @Schema(description = "Valor do veículo")
    private Double value;
}
