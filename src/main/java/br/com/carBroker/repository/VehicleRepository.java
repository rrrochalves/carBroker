package br.com.carBroker.repository;

import br.com.carBroker.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
