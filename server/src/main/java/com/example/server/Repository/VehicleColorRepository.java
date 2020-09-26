package com.example.server.Repository;

import com.example.server.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleColorRepository extends JpaRepository<VehicleColor , Long> {
    VehicleColor findByColor(String color);
}
