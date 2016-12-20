package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}
