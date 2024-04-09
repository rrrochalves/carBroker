package br.com.carBroker.repository;

import br.com.carBroker.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
