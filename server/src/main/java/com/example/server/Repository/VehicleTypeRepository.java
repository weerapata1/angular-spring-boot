package com.example.server.Repository;

import com.example.server.Entity.Vehicle;
import com.example.server.Entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    VehicleType findByNameType(String nameType);
}
