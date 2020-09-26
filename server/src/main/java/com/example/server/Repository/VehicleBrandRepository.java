package com.example.server.Repository;

import com.example.server.Entity.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleBrandRepository extends JpaRepository <VehicleBrand, Long>{
    VehicleBrand findByName(String name);

}
