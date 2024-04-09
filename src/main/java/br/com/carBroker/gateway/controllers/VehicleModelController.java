package br.com.carBroker.gateway.controllers;

import br.com.carBroker.service.VehicleModelService;
import br.com.carBroker.gateway.dto.vehicleModel.request.VehicleModelRequestDTO;
import br.com.carBroker.gateway.dto.vehicleModel.response.VehicleModelIdResponseDTO;
import br.com.carBroker.gateway.dto.vehicleModel.response.VehicleModelResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@Tag(name = "Modelo de Veiculo", description = "End-points para o dominio de modelo de veiculos da aplicação")
@RequestMapping("/vehicle-model")
@RequiredArgsConstructor
public class VehicleModelController {

    private final VehicleModelService service;

    @CrossOrigin
    @GetMapping
    @Operation(summary = "Listar modelos", description = "Listar todos os modelos")
    public ResponseEntity<List<VehicleModelResponseDTO>> getAllVehicleModel(){
        return ResponseEntity.ok(service.getAllVehicleModel());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(summary = "Listar modelo", description = "Listar modelo por id")
    public ResponseEntity<VehicleModelResponseDTO> getVehicleModelFromDTOById(@PathVariable Integer vehicleModelId) {
        return ResponseEntity.ok(service.getVehicleModelFromDTOById(vehicleModelId));
    }

    @CrossOrigin
    @PostMapping
    @Operation(summary = "Criar um modelo", description = "Criar um novo modelo de carro")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<VehicleModelIdResponseDTO> createVehicleModel(
            @Valid @RequestBody VehicleModelRequestDTO vehicleModelRequestDTO,
            UriComponentsBuilder uriComponentsBuilder) {
        VehicleModelIdResponseDTO vehicleModelIdResponseDTO = service.createVehicleModel(vehicleModelRequestDTO);

        var uri = uriComponentsBuilder.path("/vehicle-model/{id}").buildAndExpand(vehicleModelIdResponseDTO.id()).toUri();;

        return ResponseEntity.created(uri).body(vehicleModelIdResponseDTO);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um modelo de veiculo", description = "Atualiza um modelo de veiculo por id")
    public ResponseEntity<VehicleModelResponseDTO> putVehicleModel(@PathVariable Integer vehicleModelId, @Valid @RequestBody VehicleModelRequestDTO vehicleModelRequestDTO) {
        return ResponseEntity.ok(service.putVehicleModel(vehicleModelId, vehicleModelRequestDTO));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar modelo de veiculo", description = "Deletar um modelo de veiculo por id.")
    public ResponseEntity deleteVehicleModel(@PathVariable Integer vehicleModelId) {
        service.deleteVehicleModel(vehicleModelId);
        return ResponseEntity.noContent().build();
    }

}
