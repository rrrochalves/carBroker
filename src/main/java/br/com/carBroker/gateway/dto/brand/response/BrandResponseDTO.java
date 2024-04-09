package br.com.carBroker.gateway.dto.brand.response;

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
public class BrandResponseDTO {

    @Schema(description = "Id da marca")
    private Integer id;

    @Schema(description = "Nome da marca")
    private String nameBrand;
}
