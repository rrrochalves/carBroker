package br.com.carBroker.service;

import br.com.carBroker.factory.VehicleFactory;
import br.com.carBroker.domain.model.Vehicle;
import br.com.carBroker.domain.model.VehicleModel;
import br.com.carBroker.exception.VehicleNotFoundException;
import br.com.carBroker.gateway.dto.vehicle.request.VehicleRequestDTO;
import br.com.carBroker.gateway.dto.vehicle.response.VehicleIdResponseDTO;
import br.com.carBroker.gateway.dto.vehicle.response.VehicleResponseDTO;
import br.com.carBroker.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleIdResponseDTO createVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle newVehicle = Vehicle.builder()
                .year(vehicleRequestDTO.getYear())
                .fuel(vehicleRequestDTO.getFuel())
                .numberOfDoors(vehicleRequestDTO.getNumberOfDoors())
                .color(vehicleRequestDTO.getColor())
                .model(VehicleModel.builder().id(vehicleRequestDTO.getVehicleModelId()).build())
                .build();

        repository.save(newVehicle);

        return new VehicleIdResponseDTO(newVehicle.getId());
    }

    public List<VehicleResponseDTO> getAllVehicle() {
        List<Vehicle> vehicleList = repository.findAll();

        return vehicleList.stream()
                .map(VehicleFactory::convertVehicleToDTO)
                .collect(Collectors.toList());
    }

    public VehicleResponseDTO getVehicleFromDTOById(Integer vehicleId) {
        return VehicleFactory.convertVehicleToDTO(getVehicleById(vehicleId));
    }

    public VehicleResponseDTO putVehicleModel(Integer vehicleId, VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = getVehicleById(vehicleId);

        vehicle.setYear(vehicleRequestDTO.getYear());
        vehicle.setColor(vehicleRequestDTO.getColor());
        vehicle.setFuel(vehicleRequestDTO.getFuel());
        vehicle.setNumberOfDoors(vehicleRequestDTO.getNumberOfDoors());
        vehicle.setModel(VehicleModel.builder().id(vehicleRequestDTO.getVehicleModelId()).build());

        repository.save(vehicle);

        return VehicleFactory.convertVehicleToDTO(vehicle);
    }

    public void deleteVehicleModel(Integer vehicleId) {
        repository.deleteById(vehicleId);
    }

    public Vehicle getVehicleById(Integer vehicleId) {
        return repository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException(vehicleId));
    }



}
