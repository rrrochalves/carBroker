package br.com.carBroker.repository;

import br.com.carBroker.domain.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {

}
