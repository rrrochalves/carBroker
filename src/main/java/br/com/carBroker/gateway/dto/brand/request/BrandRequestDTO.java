package br.com.carBroker.gateway.dto.brand.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandRequestDTO {

        @Schema(description = "Nome da marca")
        @NotBlank(message = "Nome da Marca é obrigatório!")
        private String nameBrand;
}
