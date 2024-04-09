package br.com.carBroker.gateway.controllers;

import br.com.carBroker.gateway.dto.vehicle.request.VehicleRequestDTO;
import br.com.carBroker.gateway.dto.vehicle.response.VehicleIdResponseDTO;
import br.com.carBroker.gateway.dto.vehicle.response.VehicleResponseDTO;
import br.com.carBroker.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@Tag(name = "Veículo", description = "End-points para o dominio de veículos")
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @CrossOrigin
    @GetMapping
    @Operation(summary = "Listar carros", description = "Listar todos os carros")
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicle() {
        return ResponseEntity.ok(service.getAllVehicle());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(summary = "Listar carro", description = "Listar carro por id.")
    public ResponseEntity<VehicleResponseDTO> getVehicleFromDTOById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getVehicleFromDTOById(id));
    }

    @CrossOrigin
    @PostMapping
    @Operation(summary = "Criar carro", description = "Criar um novo carro")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<VehicleIdResponseDTO> createVehicle(
            @Valid @RequestBody VehicleRequestDTO vehicleRequestDTO,
            UriComponentsBuilder uriComponentsBuilder) {
        VehicleIdResponseDTO vehicleIdResponseDTO = service.createVehicle(vehicleRequestDTO);

        var uri = uriComponentsBuilder.path("/vehicle/{id}").buildAndExpand(vehicleIdResponseDTO.id()).toUri();;

        return ResponseEntity.created(uri).body(vehicleIdResponseDTO);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um carro", description = "Atualiza um carro por id")
    public ResponseEntity<VehicleResponseDTO> putVehicleModel(@PathVariable Integer id, @Valid @RequestBody VehicleRequestDTO vehicleModelRequestDTO) {
        return ResponseEntity.ok(service.putVehicleModel(id, vehicleModelRequestDTO));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar carro", description = "Deletar um carro por id.")
    public ResponseEntity deleteVehicleModel(@PathVariable Integer id) {
        service.deleteVehicleModel(id);
        return ResponseEntity.noContent().build();
    }
}
