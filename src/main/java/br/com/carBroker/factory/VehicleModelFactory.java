package br.com.carBroker.factory;

import br.com.carBroker.domain.model.Brand;
import br.com.carBroker.domain.model.VehicleModel;
import br.com.carBroker.gateway.dto.vehicleModel.response.VehicleModelResponseDTO;

public class VehicleModelFactory {

    public static VehicleModelResponseDTO convertVehicleModelToDTO(VehicleModel vehicleModel) {
        return VehicleModelResponseDTO.builder()
                .id(vehicleModel.getId())
                .name(vehicleModel.getName())
                .fipeValue(vehicleModel.getFipeValue())
                .brandId(vehicleModel.getBrand().getId())
                .build();
    }

    public static VehicleModel convertDTOToVehicleModel(VehicleModelResponseDTO vehicleModelResponseDTO) {
        return VehicleModel.builder()
                .id(vehicleModelResponseDTO.getId())
                .name(vehicleModelResponseDTO.getName())
                .brand(Brand.builder().id(vehicleModelResponseDTO.getBrandId()).build())
                .fipeValue(vehicleModelResponseDTO.getFipeValue())
                .build();
    }
}
