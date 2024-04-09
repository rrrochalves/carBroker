package br.com.carBroker.factory;

import br.com.carBroker.gateway.dto.brand.request.BrandRequestDTO;
import br.com.carBroker.gateway.dto.brand.response.BrandResponseDTO;
import br.com.carBroker.domain.model.Brand;

public class BrandFactory {

    public static Brand createBrand(BrandRequestDTO brandRequestDTO) {
        return Brand.builder()
                .nameBrand(brandRequestDTO.getNameBrand())
                .build();
    }

    public static BrandResponseDTO convertBrandToDTO(Brand brand) {
        return BrandResponseDTO.builder()
                .id(brand.getId())
                .nameBrand(brand.getNameBrand())
                .build();
    }
}
