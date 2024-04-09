package br.com.carBroker.service;

import br.com.carBroker.domain.model.Brand;
import br.com.carBroker.domain.model.VehicleModel;
import br.com.carBroker.exception.VehicleModelNotFoundException;
import br.com.carBroker.factory.VehicleModelFactory;
import br.com.carBroker.gateway.dto.vehicleModel.response.VehicleModelIdResponseDTO;
import br.com.carBroker.gateway.dto.vehicleModel.request.VehicleModelRequestDTO;
import br.com.carBroker.gateway.dto.vehicleModel.response.VehicleModelResponseDTO;
import br.com.carBroker.repository.VehicleModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleModelService {

    private final VehicleModelRepository repository;

    public VehicleModelIdResponseDTO createVehicleModel(VehicleModelRequestDTO vehicleModelRequestDTO) {

        VehicleModel newVehicleModel = VehicleModel.builder()
                .name(vehicleModelRequestDTO.getName())
                .brand(Brand.builder().id(vehicleModelRequestDTO.getBrandId()).build())
                .fipeValue(vehicleModelRequestDTO.getFipeValue())
                .build();

        repository.save(newVehicleModel);

        return new VehicleModelIdResponseDTO(newVehicleModel.getId());
    }

    public List<VehicleModelResponseDTO> getAllVehicleModel() {
        List<VehicleModel> vehicleModelList = repository.findAll();

        return vehicleModelList.stream()
                .map(VehicleModelFactory::convertVehicleModelToDTO)
                .collect(Collectors.toList());
    }

    public VehicleModelResponseDTO getVehicleModelFromDTOById(Integer vehicleModelId) {
        return VehicleModelFactory
                .convertVehicleModelToDTO(getVehicleModelById(vehicleModelId));
    }

    public VehicleModelResponseDTO putVehicleModel(Integer vehicleModelId, VehicleModelRequestDTO vehicleModelRequestDTO) {
        VehicleModel vehicleModel = getVehicleModelById(vehicleModelId);

        vehicleModel.setName(vehicleModelRequestDTO.getName());
        vehicleModel.setBrand(Brand.builder().id(vehicleModelRequestDTO.getBrandId()).build());
        vehicleModel.setFipeValue(vehicleModelRequestDTO.getFipeValue());

        repository.save(vehicleModel);

        return VehicleModelFactory.convertVehicleModelToDTO(vehicleModel);
    }

    public void deleteVehicleModel(Integer vehicleModelId) {
        repository.deleteById(vehicleModelId);
    }

    public VehicleModel getVehicleModelById(Integer vehicleModelId) {
        return repository.findById(vehicleModelId)
                .orElseThrow(() -> new VehicleModelNotFoundException(vehicleModelId));
    }
}
