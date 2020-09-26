package com.example.server.Repository;

import com.example.server.Entity.ImageVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ImageVehicleRepository extends JpaRepository<ImageVehicle ,Long> {

}
