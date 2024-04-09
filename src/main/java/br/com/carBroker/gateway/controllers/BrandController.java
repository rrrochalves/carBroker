package br.com.carBroker.gateway.controllers;

import br.com.carBroker.gateway.dto.brand.request.BrandRequestDTO;
import br.com.carBroker.gateway.dto.brand.response.BrandIdResponseDTO;
import br.com.carBroker.gateway.dto.brand.response.BrandResponseDTO;
import br.com.carBroker.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@Tag(name = "Marcas de veículos", description = "End-points para o dominio de marcas de veículos da aplicação")
@RequestMapping("/brand")
public class BrandController {

    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping
    @Operation(summary = "Listar marcas", description = "Listar todas as Marcas")
    public ResponseEntity<List<BrandResponseDTO>> getAllBrands() {
        return ResponseEntity.ok(service.getAllBrands());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(summary = "Listar marca", description = "Listar uma marca por Id")
    public ResponseEntity<BrandResponseDTO> getBrandFromDTOById(@PathVariable Integer brandId) {
        return ResponseEntity.ok(service.getBrandFromDTOById(brandId));
    }

    @CrossOrigin
    @PostMapping
    @Operation(summary = "Criar uma marca", description = "Criar uma nova marca")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<BrandIdResponseDTO> createBrand(@RequestBody @Valid BrandRequestDTO brandRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        BrandIdResponseDTO brandIdResponseDTO = service.createBrand(brandRequestDTO);

        var uri = uriComponentsBuilder.path("/brand/{id}").buildAndExpand(brandIdResponseDTO.id()).toUri();;

        return ResponseEntity.created(uri).body(brandIdResponseDTO);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar marca", description = "Atualiza uma marca por Id")
    public ResponseEntity<BrandResponseDTO> putBrand(@PathVariable Integer brandId, @RequestBody @Valid BrandRequestDTO brand) {
        return ResponseEntity.ok(service.putBrand(brandId, brand));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar marca", description = "Deleta uma marca por Id")
    public ResponseEntity deleteBrand(@PathVariable Integer brandId) {
        service.deleteBrand(brandId);
        return ResponseEntity.noContent().build();
    }



}
