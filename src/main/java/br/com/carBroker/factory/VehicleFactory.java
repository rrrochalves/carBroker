package br.com.carBroker.factory;

import br.com.carBroker.domain.model.Vehicle;
import br.com.carBroker.gateway.dto.vehicle.response.VehicleResponseDTO;

public class VehicleFactory {

    public static VehicleResponseDTO convertVehicleToDTO(Vehicle vehicle){

        return VehicleResponseDTO.builder()
                .id(vehicle.getId())
                .createAt(vehicle.getCreateAt())
                .modelId(vehicle.getModel().getId())
                .year(vehicle.getYear())
                .fuel(vehicle.getFuel())
                .numberOfDoors(vehicle.getNumberOfDoors())
                .color(vehicle.getColor())
                .modelName(vehicle.getModel().getName())
                .value(vehicle.getModel().getFipeValue())
                .build();
    }
}
