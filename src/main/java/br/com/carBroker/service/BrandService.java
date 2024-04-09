package br.com.carBroker.service;


import br.com.carBroker.factory.BrandFactory;
import br.com.carBroker.domain.model.Brand;
import br.com.carBroker.exception.BrandNotFoundException;
import br.com.carBroker.gateway.dto.brand.request.BrandRequestDTO;
import br.com.carBroker.gateway.dto.brand.response.BrandIdResponseDTO;
import br.com.carBroker.gateway.dto.brand.response.BrandResponseDTO;
import br.com.carBroker.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repository;
    public BrandIdResponseDTO createBrand(BrandRequestDTO brandRequestDTO) {
        Brand newBrand = BrandFactory.createBrand(brandRequestDTO);
        repository.save(newBrand);
        return new BrandIdResponseDTO(newBrand.getId());
    }

    public List<BrandResponseDTO> getAllBrands() {
        List<Brand> brandList = repository.findAll();

        return brandList.stream()
                .map(BrandFactory::convertBrandToDTO)
                .collect(Collectors.toList());
    }

    public BrandResponseDTO getBrandFromDTOById(Integer brandId) {
        return BrandFactory
                .convertBrandToDTO(getBrandById(brandId));
    }

    public BrandResponseDTO putBrand(Integer brandId, BrandRequestDTO brandRequestDTO) {
        Brand brand = getBrandById(brandId);

        brand.setNameBrand(brandRequestDTO.getNameBrand());
        repository.save(brand);
        return BrandFactory.convertBrandToDTO(brand);
    }

    public void deleteBrand(Integer brandId) {
        repository.deleteById(brandId);
    }

    public Brand getBrandById(Integer brandId) {
       return repository.findById(brandId)
                .orElseThrow(() -> new BrandNotFoundException(brandId));
    }


}
