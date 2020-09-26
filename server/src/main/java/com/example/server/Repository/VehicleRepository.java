package com.example.server.Repository;

import com.example.server.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface VehicleRepository extends JpaRepository <Vehicle, Long> {
    Optional<Vehicle> findBySerialNo(String serialNo);
}
